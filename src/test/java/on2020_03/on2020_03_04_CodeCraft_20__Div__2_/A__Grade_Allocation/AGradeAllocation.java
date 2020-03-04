package on2020_03.on2020_03_04_CodeCraft_20__Div__2_.A__Grade_Allocation;



import template.io.FastInput;
import template.io.FastOutput;

public class AGradeAllocation {
    public void solve(int testNumber, FastInput in, FastOutput out) {
        int n = in.readInt();
        int m = in.readInt();
        int[] a = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            a[i] = in.readInt();
            sum += a[i];
        }
        out.println(Math.min(m, sum));
    }
}
