package template.datastructure;

import template.binary.Log2;
import template.primitve.generated.datastructure.LongIterator;
import template.rand.FastUniversalHashFunction0;
import template.rand.HashFunction;
import template.rand.RandomWrapper;

import java.util.*;

/**
 * <p>
 * implementation of perfect hash which mentioned in "Introduction on Algorithms"
 * </p>
 * <p>
 * insert all n elements in O(10n) expected time and 176n byte spaces complexity
 * </p>
 * <p>
 * query has O(1) performance in worst case
 * </p>
 */
public class PerfectHashing<V> implements Iterable<V> {
    HashFunction f1 = FastUniversalHashFunction0.getInstance();
    HashFunction[] f2;
    long notExistKey;
    int[] starts;
    int[] masks;
    long[] K;
    Object[] V;
    int globalMask;

    /**
     * m should greater or equal to n
     */
    private PerfectHashing(int m) {
        m = 1 << Log2.ceilLog(m);
        globalMask = m - 1;
        starts = new int[m];
        masks = new int[m];
        f2 = new HashFunction[m];
        for (int i = 0; i < m; i++) {
            f2[i] = FastUniversalHashFunction0.getInstance();
        }
    }


    public PerfectHashing(long[] keys, V[] values) {
        this((int) Math.ceil(keys.length));
        while (true) {
            notExistKey = RandomWrapper.INSTANCE.nextLong();
            boolean find = false;
            for (long k : keys) {
                if (k == notExistKey) {
                    find = true;
                    break;
                }
            }
            if (!find) {
                break;
            }
        }
        init0(keys, values, new int[keys.length]);
    }


    private void init0(long[] keys, V[] values, int[] h1) {
        int n = keys.length;
        Arrays.fill(masks, 0);
        for (int i = 0; i < n; i++) {
            long k = keys[i];
            masks[h1[i] = ((int) f1.f(k) & globalMask)]++;
        }
        long total = 0;
        for (int i = 0; i < n; i++) {
            total += (1L << Log2.ceilLog((long) masks[i] * masks[i]));
        }
        //success hash
        if (total >= 5 * starts.length) {
            f1 = f1.upgrade();
            init0(keys, values, h1);
            return;
        }
        for (int i = 0; i < masks.length; i++) {
            starts[i] = masks[i];
            if (i > 0) {
                starts[i] += starts[i - 1];
            }
        }
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[--starts[h1[i]]] = i;
        }
        total = 0;
        for (int i = 0; i < starts.length; i++) {
            starts[i] = (int) total;
            masks[i] = (int) ((1L << Log2.ceilLog((long) masks[i] * masks[i])) - 1);
            total += masks[i] + 1;
        }
        K = new long[(int) total];
        V = new Object[(int) total];
        for (int i = 0; i < n; i++) {
            int l = i;
            int r = l;
            int h = h1[indices[l]];
            int L = starts[h];
            int M = masks[h];
            while (r + 1 < n && h == h1[indices[r + 1]]) {
                r++;
            }
            i = r;
            while (true) {
                Arrays.fill(K, L, L + M + 1, notExistKey);
                boolean success = true;
                HashFunction f = f2[h];
                for (int j = l; j <= r; j++) {
                    int index = indices[j];
                    int h2 = L + ((int) f.f(keys[index]) & M);
                    if (K[h2] != notExistKey) {
                        success = false;
                        break;
                    }
                    V[h2] = values[index];
                    K[h2] = keys[index];
                }

                if (success) {
                    break;
                }

                f2[h] = f2[h].upgrade();
            }
        }
    }

    public LongIterator keyIterator() {
        return new LongIterator() {
            int cur = 0;

            @Override
            public boolean hasNext() {
                while (cur <= globalMask && K[cur] == notExistKey) {
                    cur++;
                }
                return cur <= globalMask;
            }

            @Override
            public long next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return K[cur];
            }
        };
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            int cur = 0;

            @Override
            public boolean hasNext() {
                while (cur <= globalMask && K[cur] == notExistKey) {
                    cur++;
                }
                return cur <= globalMask;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (V) V[cur];
            }
        };
    }

    public static final int THRESHOLD = 4;

    public V getOrDefault(long key, V def) {
//        int h1 = (int) f1.f(key) & globalMask;
//        if (masks[h1] <= THRESHOLD) {
//            int l = starts[h1];
//            int r = l + masks[h1];
//            while (l <= r) {
//                if (K[l] != key || key == notExistKey) {
//                    l++;
//                } else {
//                    return (V) V[l];
//                }
//            }
//            return def;
//        }
//        int h2 = ((int) f2[h1].f(key) & masks[h1]);
//        int index = starts[h1] + h2;
//        return K[index] != key || key == notExistKey ? def : (V) V[index];
        int h1 = (int) f1.f(key) & globalMask;
        int h2 = masks[h1] == 0 ? 0 : ((int) f2[h1].f(key) & masks[h1]);
        int index = starts[h1] + h2;
        return K[index] != key || key == notExistKey ? def : (V) V[index];

    }

    public V get(long key) {
        return getOrDefault(key, null);
    }

    private static Object notExistValue = new Object();

    public boolean containKey(long key) {
        return getOrDefault(key, (V) notExistValue) != notExistValue;
    }

    @Override
    public String toString() {
        Map<Long, V> map = new HashMap<>();
        for (int i = 0; i < K.length; i++) {
            if (K[i] == notExistKey) {
                continue;
            }
            map.put(K[i], (V)V[i]);
        }
        return map.toString();
    }
}
