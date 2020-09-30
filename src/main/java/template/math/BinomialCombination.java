package template.math;

import template.binary.Bits;
import template.binary.Log2;
import template.datastructure.Loop;
import template.polynomial.FastFourierTransform;
import template.polynomial.Polynomials;
import template.primitve.generated.datastructure.IntegerArrayList;

/**
 * 计算C(n,0),C(n,1),...,C(n,m)在模p的情况下的值，其中p不一定是素数。
 * 时间复杂度是暴力计算：O(m^2 log_2n)或使用FFT：O(m log_2m log_2n)
 */
public class BinomialCombination {
    private int m;
    private Modular mod;
    private IntegerArrayList composites;
    private boolean fft;

    public BinomialCombination(long n, int m, Modular mod, boolean fft) {
        this.m = m;
        this.mod = mod;
        this.fft = fft;
        composites = pow(n);
        composites.expandWith(0, m + 1);
    }

    /**
     * Return C(n, i)
     */
    public int get(int i) {
        return composites.get(i);
    }

    /**
     * return a * b
     */
    private void mul(IntegerArrayList a, IntegerArrayList b, IntegerArrayList c) {
        if (!fft) {
            Polynomials.mul(a, b, c, mod.getMod());
        } else {
            int[] ans = FastFourierTransform.multiplyMod(a.getData(), a.size(), b.getData(), b.size(), mod.getMod());
            c.clear();
            c.addAll(ans);
        }
        trim(c);
    }

    private void trim(IntegerArrayList x) {
        if (x.size() > m + 1) {
            x.remove(m + 1, x.size() - 1);
        }
    }

    /**
     * return p * (x + 1)
     */
    private void mul(IntegerArrayList p, IntegerArrayList ans) {
        ans.clear();
        ans.expandWith(0, p.size() + 1);

        int n = p.size();
        for (int i = 0; i < n; i++) {
            int val = p.get(i);
            ans.set(i, mod.plus(ans.get(i), val));
            ans.set(i + 1, val);
        }

        trim(ans);
    }

    private IntegerArrayList pow(long exp) {
        int ceil = Log2.ceilLog(m + 1 + m);
        Loop<IntegerArrayList> loop = new Loop<>(new IntegerArrayList(1 << ceil), new IntegerArrayList(1 << ceil));
        loop.get().add(1);
        for (int i = Log2.floorLog(exp); i >= 0; i--) {
            mul(loop.get(), loop.get(), loop.turn());
            if (1 == Bits.get(exp, i)) {
                mul(loop.get(), loop.turn());
            }
        }
        return loop.get();
    }
}
