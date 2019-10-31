package template;

public class PreXor {
    private long[] pre;

    public PreXor(long[] a) {
        int n = a.length;
        pre = new long[n];
        pre[0] = a[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] ^ a[i];
        }
    }

    public int length(){
        return pre.length;
    }

    public PreXor(int[] a) {
        int n = a.length;
        pre = new long[n];
        pre[0] = a[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] ^ a[i];
        }
    }

    /**
     * get a[l] + a[l + 1] + ... + a[r]
     */
    public long intervalSum(int l, int r) {
        if (l == 0) {
            return pre[r];
        }
        return pre[r] ^ pre[l - 1];
    }

    /**
     * get a[0] + a[1] + ... + a[i]
     */
    public long prefix(int i) {
        return pre[i];
    }

    /**
     * get a[i] + a[i + 1] + ... + a[n - 1]
     */
    public long post(int i) {
        if (i == 0) {
            return pre[pre.length - 1];
        }
        return pre[pre.length - 1] ^ pre[i - 1];
    }
}
