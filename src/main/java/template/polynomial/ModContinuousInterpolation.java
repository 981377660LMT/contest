package template.polynomial;

import template.math.DigitUtils;
import template.math.Factorial;

/**
 * https://atcoder.jp/contests/abc208/editorial/2219
 */
public class ModContinuousInterpolation {
    private int mod;
    private int[] pre;
    private int[] post;
    private Factorial fact;

    public ModContinuousInterpolation(int maxN, int mod) {
        this(maxN, new Factorial(maxN + 10, mod));
    }

    /**
     * <pre>
     * Given n points, the i-th points located at (x0+i,y[i])
     * </pre>
     * <p>
     * precondition: fact are supposed to support [0, n - 1]
     * </p>
     */
    public ModContinuousInterpolation(int maxN, Factorial fact) {
        this.mod = fact.getMod();
        pre = new int[maxN + 10];
        post = new int[maxN + 10];
        this.fact = fact;
    }

    /**
     * Let f(x + i)=y[i], find f(x) in O(n)
     */
    public int interpolate(int x0, int[] y, int n, long x) {
        x = DigitUtils.mod(x - x0, mod);
        if (x < n) {
            return y[(int) x];
        }

        for (int i = 0; i < n; i++) {
            pre[i] = post[i] = (int) DigitUtils.modsub(x, i, mod);
        }
        for (int i = 1; i < n; i++) {
            pre[i] = (int) ((long) pre[i - 1] * pre[i] % mod);
            post[n - i - 1] = (int) ((long) post[n - i - 1] * post[n - i] % mod);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long local = (long) y[i] * fact.invFact(i) % mod * fact.invFact(n - 1 - i) % mod;
            if (i > 0) {
                local = local * pre[i - 1] % mod;
            }
            if (i + 1 < n) {
                local = local * post[i + 1] % mod;
            }
            if (((n - 1 - i) & 1) == 1) {
                local = -local;
            }
            sum += local;
        }

        return DigitUtils.mod(sum, mod);
    }
}
