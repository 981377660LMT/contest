package on2020_05.on2020_05_28_Codeforces___Playrix_Codescapes_Cup__Codeforces_Round__413__rated__Div__1___Div__2_.A__Carrot_Cakes;



import template.io.FastInput;
import template.io.FastOutput;
import template.math.DigitUtils;

public class ACarrotCakes {
    public void solve(int testNumber, FastInput in, FastOutput out) {
        int n = in.readInt();
        int t = in.readInt();
        int k = in.readInt();
        int d = in.readInt();

        int oldCost = DigitUtils.ceilDiv(n, k) * t;

        int time = 0;
        int cur = 0;
        while (cur < n) {
            time++;
            if (time % t == 0) {
                cur += k;
            }
            if (time > d && (time - d) % t == 0) {
                cur += k;
            }
        }

        out.println(time < oldCost ? "YES" : "NO");
    }
}
