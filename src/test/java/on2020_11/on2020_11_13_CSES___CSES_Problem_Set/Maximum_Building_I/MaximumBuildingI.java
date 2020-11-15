package on2020_11.on2020_11_13_CSES___CSES_Problem_Set.Maximum_Building_I;



import template.io.FastInput;
import template.io.FastOutput;
import template.problem.RectOnGridProblem;
import template.utils.Debug;

public class MaximumBuildingI {
    Debug debug = new Debug(false);
    public void solve(int testNumber, FastInput in, FastOutput out) {
        int n = in.readInt();
        int m = in.readInt();
        int[][] mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = in.readChar() == '*' ? 1 : 0;
            }
        }
        int[] ans = RectOnGridProblem.maximumRectArea((i, j) -> mat[i][j], n, m);
        debug.debugMatrix("mat", mat);
        debug.debug("ans", ans);
        out.println(ans[0]);
    }
}
