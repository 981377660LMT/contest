package template.binary;

public class BitCount {
    private static int[] size = new int[1 << 8];

    static {
        for (int i = 0; i < size.length; i++) {
            size[i] = Integer.bitCount(i);
        }
    }


    static final int MASK = (1 << 8) - 1;
    public static int count(int x) {
        int ans = 0;
        ans += size[x & MASK];
        x >>>= 8;
        ans += size[x & MASK];
        x >>>= 8;
        ans += size[x & MASK];
        x >>>= 8;
        ans += size[x & MASK];
        return ans;
    }
    public static int count(long x) {
        return count((int) x) + count((int) (x >>> 32));
    }
}
