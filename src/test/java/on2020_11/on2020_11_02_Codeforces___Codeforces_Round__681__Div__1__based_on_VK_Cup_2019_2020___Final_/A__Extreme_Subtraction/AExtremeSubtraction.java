package on2020_11.on2020_11_02_Codeforces___Codeforces_Round__681__Div__1__based_on_VK_Cup_2019_2020___Final_.A__Extreme_Subtraction;



import template.io.FastInput;
import template.io.FastOutput;

public class AExtremeSubtraction {
    public void solve(int testNumber, FastInput in, FastOutput out) {
        int n = in.readInt();
        int[] a = new int[n];
        in.populate(a);
        int high = (int) 1e9;
        int low = 0;
        for (int x : a) {
            if (x < low) {
                out.println("NO");
                return;
            }
            x -= low;
            if (x >= high) {
                low += x - high;
            } else {
                high = x;
            }
        }
        out.println("YES");
    }
}
