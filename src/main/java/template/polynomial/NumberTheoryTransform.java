package template.polynomial;

import template.binary.Log2;
import template.math.Power;
import template.utils.PrimitiveBuffers;

import java.util.Arrays;

public class NumberTheoryTransform {
    public static void main(String[] args) {
        int[] ans = new int[]{0, 1};
        int mod = 998_244_353;
        int g = 3;
        Power pow = new Power(mod);
        ntt(ans, false, mod, g, pow);
        System.out.println(Arrays.toString(ans));
        ntt(ans, true, mod, g, pow);
        System.out.println(Arrays.toString(ans));

    }

    /**
     * Normal but correct ntt
     */
    public static void ntt(int[] p, boolean inv, int mod, int g, Power power) {
//        Modular modular = new DoubleModular(mod);

        int m = Log2.ceilLog(p.length);
        int n = 1 << m;

        int shift = 32 - Integer.numberOfTrailingZeros(n);
        for (int i = 1; i < n; i++) {
            int j = Integer.reverse(i << shift);
            if (i < j) {
                int temp = p[i];
                p[i] = p[j];
                p[j] = temp;
            }
        }

        int[] ws = PrimitiveBuffers.allocIntPow2(n / 2);
        int unit = power.pow(g, (mod - 1) / n);
        ws[0] = 1;
        for (int i = 1; i < ws.length; i++) {
            ws[i] = (int) (((long) ws[i - 1] * unit) % mod);
//            ws[i] = modular.mul(ws[i - 1], unit);
        }

        for (int d = 0; d < m; d++) {
            //int w1 = power.pow(g, (mod - 1) >> 1 + d);
            //w1=g^{(mod-1)/2^{1+d}}
            //int w1 = ws[d];
            int s = 1 << d;
            int s2 = s << 1;
            int right = n >> (1 + d);
            for (int i = 0; i < n; i += s2) {
                //int w = 1;
                for (int j = 0; j < s; j++) {
                    int a = i + j;
                    int b = a + s;
                    int t = (int) ((long) ws[j * right] * p[b] % mod);
//                    int t = modular.mul(ws[j * right], p[b]);
                    p[b] = p[a] - t;
                    if (p[b] < 0) {
                        p[b] += mod;
                    }
                    p[a] = p[a] + t;
                    if (p[a] >= mod) {
                        p[a] -= mod;
                    }
                    //w = g^{j (mod-1)/2^{1+d}}
                    //unit = g^{(mod-1)/n}
                    //w = unit^{j n/2^{1+d}}
                    //w = (int) ((long) w * w1 % mod);
                }
            }
        }

        PrimitiveBuffers.release(ws);
        if (inv) {
            long invN = power.inverse(n);
            for (int i = 0, j = 0; i <= j; i++, j = n - i) {
                int a = p[j];
                p[j] = (int) (p[i] * invN % mod);
//                p[j] = modular.mul(p[i], (int) invN);
                if (i != j) {
                    p[i] = (int) (a * invN % mod);
//                    p[i] = modular.mul(a, (int) invN);
                }
            }
        }
    }
}
