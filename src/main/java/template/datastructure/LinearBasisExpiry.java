package template.datastructure;

import template.binary.Bits;
import template.binary.Log2;

import java.util.Arrays;

public class LinearBasisExpiry {
    private static final int BITS = 64;

    /**
     * expiries[i] : the expiry for the element with id = i
     */
    private int[] expiries = new int[BITS];
    private long[] map = new long[BITS];
    /**
     * map[i] = xor of source[i]
     */
    private long[] source = new long[BITS];
    private long set;

    public int size() {
        return Long.bitCount(set);
    }

    public void clear() {
        set = 0;
        Arrays.fill(map, 0);
        Arrays.fill(source, 0);
        Arrays.fill(expiries, 0);
    }

    public long getSet(){
        return set;
    }

    public long representation(long x) {
        long ans = 0;
        for (int i = BITS - 1; i >= 0 && x != 0; i--) {
            if (bitAt(x, i) == 0 || map[i] == 0) {
                continue;
            }
            x ^= map[i];
            ans ^= 1L << i;
        }
        return x == 0 ? ans : -1;
    }

    public long representationOriginal(long x) {
        long ans = 0;
        for (int i = BITS - 1; i >= 0 && x != 0; i--) {
            if (bitAt(x, i) == 0 || map[i] == 0) {
                continue;
            }
            x ^= map[i];
            ans ^= source[i];
        }
        return x == 0 ? ans : -1;
    }

    public int getExpiry(int i) {
        return expiries[i];
    }

    public int minExpiry(long x) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < BITS; i++) {
            if (Bits.get(x, i) == 1) {
                ans = Math.min(ans, expiries[i]);
            }
        }
        return ans;
    }

    public int maxExpiry(long x) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < BITS; i++) {
            if (Bits.get(x, i) == 1) {
                ans = Math.max(ans, expiries[i]);
            }
        }
        return ans;
    }

    public long[] toArray() {
        long[] ans = new long[size()];
        int tail = 0;
        for (int i = BITS - 1; i >= 0; i--) {
            if (map[i] != 0) {
                ans[tail++] = map[i];
            }
        }
        return ans;
    }

    private void upward(int row) {
        assert 1L << row == Long.highestOneBit(map[row]);
        for (int i = row + 1; i < BITS; i++) {
            if (Bits.get(map[i], row) == 1) {
                map[i] ^= map[row];
                source[i] ^= source[row];
            }
        }
    }

    private boolean check() {
        for (int i = 0; i < BITS; i++) {
            if ((map[i] == 0) != (Bits.get(set, i) == 0)) {
                return false;
            }
            if (map[i] != 0) {
                for (int j = 0; j < BITS; j++) {
                    int res = Bits.get(map[i], j);
                    if (i == j) {
                        if (res != 1) {
                            return false;
                        }
                    } else {
                        if (res == 1 && Bits.get(set, j) == 1) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * return the index of  added element ([0,BITS)), -1 means can't add val
     *
     * @param val
     * @return
     */
    public int add(long val, int expiry) {
        long state = 0;
        for (int i = BITS - 1; i >= 0 && val != 0; i--) {
            if (bitAt(val, i) == 0 || map[i] == 0) {
                continue;
            }
            val ^= map[i];
            state ^= source[i];
        }
        if (val != 0) {
            int log = Log2.floorLog(val);
            map[log] = val;
            source[log] = state | (1L << log);
            expiries[log] = expiry;
            set |= 1L << log;
            upward(log);

            assert check();
            return log;
        }
        int minIndex = -1;
        int minExpiry = Integer.MAX_VALUE;
        for (int i = 0; i < BITS; i++) {
            if (bitAt(state, i) == 0) {
                continue;
            }
            if (expiries[i] < minExpiry) {
                minExpiry = expiries[i];
                minIndex = i;
            }
        }
        if (minExpiry < expiry) {
            //replace
            long xor = Bits.clear(state, minIndex);
            for (int i = 0; i < BITS; i++) {
                if (Bits.get(source[i], minIndex) == 1) {
                    source[i] ^= xor;
                }
            }
            expiries[minIndex] = expiry;
            return minIndex;
        }
        return -1;
    }

    /**
     * Check whether val can be get by xor the numbers in basis
     */
    public boolean contain(long val) {
        for (int i = BITS - 1; i >= 0 && val != 0; i--) {
            if (bitAt(val, i) == 0) {
                continue;
            }
            val ^= map[i];
        }
        return val == 0;
    }

    public void copy(LinearBasisExpiry model) {
        System.arraycopy(model.map, 0, map, 0, map.length);
        System.arraycopy(model.source, 0, source, 0, source.length);
        System.arraycopy(model.expiries, 0, expiries, 0, expiries.length);
        set = model.set;
    }

    private long bitAt(long val, int i) {
        return (val >>> i) & 1;
    }

    public long xorNumberCount() {
        return 1L << size();
    }

    /**
     * Find the k-th smallest possible generated number, and we consider 0 is the 0-th smallest.
     */
    public long theKthSmallestNumber(long k) {
        int id = 0;
        long num = 0;
        for (int i = 0; i < BITS; i++) {
            if (map[i] == 0) {
                continue;
            }
            if (bitAt(k, id) == 1) {
                num ^= map[i];
            }
            id++;
        }
        return num;
    }

    /**
     * The rank of n in all generated numbers, 0's rank is 0
     */
    public long theRankOfNumber(long n) {
        int index = size() - 1;
        long rank = 0;
        for (int i = BITS - 1; i >= 0; i--) {
            if (map[i] == 0) {
                continue;
            }
            if (bitAt(n, i) == 1) {
                rank |= 1L << index;
                n ^= map[i];
            }
            index--;
        }
        return rank;
    }

    /**
     * Find the maximum value x ^ v where v is generated
     */
    public long theMaximumNumberXor(long x) {
        for (int i = BITS - 1; i >= 0; i--) {
            if (map[i] == 0) {
                continue;
            }
            if (bitAt(x, i) == 0) {
                x ^= map[i];
            }
        }
        return x;
    }

    /**
     * Find the minimum value x ^ v where v belong to spanning space of this
     */
    public int theMinimumNumberXor(int x) {
        for (int i = BITS - 1; i >= 0; i--) {
            if (map[i] == 0) {
                continue;
            }
            if (bitAt(x, i) == 1) {
                x ^= map[i];
            }
        }
        return x;
    }

    @Override
    public LinearBasisExpiry clone() {
        try {
            LinearBasisExpiry ans = (LinearBasisExpiry) super.clone();
            ans.map = ans.map.clone();
            ans.source = ans.source.clone();
            ans.expiries = ans.expiries.clone();
            return ans;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
