package template.primitve.generated.datastructure;

public class DoubleBIT2D {
    private double[][] data;
    private int n;
    private int m;

    /**
     * 创建大小A[1...n][1..,m]
     */
    public DoubleBIT2D(int n, int m) {
        this.n = n;
        this.m = m;
        data = new double[n + 1][m + 1];
    }

    /**
     * 查询左上角为(1,1)，右下角为(x,y)的矩形和
     */
    public double query(int x, int y) {
        double sum = 0;
        for (int i = x; i > 0; i -= i & -i) {
            for (int j = y; j > 0; j -= j & -j) {
                sum += data[i][j];
            }
        }
        return sum;
    }


    /**
     * 查询左上角为(ltx,lty)，右下角为(rbx,rby)的矩形和
     */
    public double rect(int ltx, int lty, int rbx, int rby) {
        return query(rbx, rby) - query(ltx - 1, rby) - query(rbx, lty - 1) + query(ltx - 1, lty - 1);
    }

    /**
     * 将A[x][y] 更新为A[x][y]+mod
     */
    public void update(int x, int y, double mod) {
        for (int i = x; i <= n; i += i & -i) {
            for (int j = y; j <= m; j += j & -j) {
                data[i][j] += mod;
            }
        }
    }

    /**
     * 将A[x][y] 更新为mod
     */
    public void set(int x, int y, double mod) {
        update(x, y, mod - rect(x, x, y, y));
    }

    /**
     * 将A全部清0
     */
    public void clear(int n, int m) {
        this.n = n;
        this.m = m;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                data[i][j] = 0;
            }
        }
    }

    public void clear() {
        clear(n, m);
    }

    public void clear(Int2ToDoubleFunction func, int n, int m) {
        this.n = n;
        this.m = m;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                data[i][j] = func.apply(i, j);
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int ni = i + (i & -i);
                int nj = j + (j & -j);
                if (ni <= n) {
                    data[ni][j] += data[i][j];
                }
                if (nj <= m) {
                    data[i][nj] += data[i][j];
                }
                if (ni <= n && nj <= m) {
                    data[ni][nj] -= data[i][j];
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                builder.append(query(i, j) + query(i - 1, j - 1) - query(i - 1, j) - query(i, j - 1)).append(' ');
            }
            builder.append('\n');
        }
        return builder.toString();
    }
}
