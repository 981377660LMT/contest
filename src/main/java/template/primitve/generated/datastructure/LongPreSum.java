package template.primitve.generated.datastructure;

public class LongPreSum {
    private long[] pre;
    private int n;

    public LongPreSum(int n) {
        pre = new long[n];
    }

    public void populate(IntToLongFunction a, int n) {
        this.n = n;
        if (n == 0) {
            return;
        }
        pre[0] = a.apply(0);
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + a.apply(i);
        }
    }

    public LongPreSum(IntToLongFunction a, int n) {
        this(n);
        populate(a, n);
    }

    /**
     * get a[l] + a[l + 1] + ... + a[r]
     */
    public long intervalSum(int l, int r) {
        return prefix(r) - prefix(l - 1);
    }

    /**
     * get a[0] + a[1] + ... + a[i]
     */
    public long prefix(int i) {
        i = Math.min(i, n - 1);
        if (i < 0) {
            return 0;
        }
        return pre[i];
    }

    /**
     * get a[i] + a[i + 1] + ... + a[n - 1]
     */
    public long post(int i) {
        return prefix(n) - prefix(i - 1);
    }
}
