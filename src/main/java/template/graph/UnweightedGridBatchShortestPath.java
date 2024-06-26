package template.graph;

import template.math.DigitUtils;
import template.primitve.generated.datastructure.LongDeque;
import template.primitve.generated.datastructure.LongDequeImpl;

public class UnweightedGridBatchShortestPath {
    boolean[][] passable;
    int[][] dirs;
    int n;
    int m;
    LongDeque dq;
    public static int inf = (int) 1e9;
    boolean[][][] adj;

    /**
     * -1 <= dirs[i][0,1] <= 1
     *
     * @param passable
     * @param dirs
     */
    public UnweightedGridBatchShortestPath(boolean[][] passable, int[][] dirs, boolean[][][] adj) {
        this.passable = passable;
        this.dirs = dirs;
        n = passable.length;
        m = passable[0].length;
        dq = new LongDequeImpl(n * m);
        dist = new int[n][m];
        this.adj = adj;
    }

    /**
     * <p>
     * the answer for the i-th query is the shortest path between (srcX[i], srcY[i]) to (dstX[i], dstY[i])
     * </p>
     * <p>
     * k: the length of queries
     * <br>
     * time complexity: O(knm(n+m) + q\log_2nm)
     * </p>
     * <p>
     * res[i] = inf means there isn't a path between the two positions
     * </p>
     */
    public int[] query(int[] srcX, int[] srcY, int[] dstX, int[] dstY) {
        int k = srcX.length;
        qs = new Query[k];
        for (int i = 0; i < k; i++) {
            qs[i] = new Query(srcX[i], srcY[i], dstX[i], dstY[i], inf);
        }
        Query[] original = qs.clone();
        buf = new Query[k];
        dac(0, n - 1, 0, m - 1, 0, k - 1);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = original[i].ans;
        }
        return ans;
    }


    Query[] buf;
    Query[] qs;
    int[][] dist;

    private void process(int b, int t, int l, int r, int srcX, int srcY, int L, int R) {
        if (!passable[srcX][srcY]) {
            return;
        }

        for (int i = b; i <= t; i++) {
            for (int j = l; j <= r; j++) {
                dist[i][j] = inf;
            }
        }
        dist[srcX][srcY] = 0;
        assert dq.isEmpty();
        dq.addLast(DigitUtils.asLong(srcX, srcY));
        while (!dq.isEmpty()) {
            long head = dq.removeFirst();
            int x = DigitUtils.highBit(head);
            int y = DigitUtils.lowBit(head);
            for (int i = 0; i < dirs.length; i++) {
                if (!adj[i][x][y]) {
                    continue;
                }
                int[] dir = dirs[i];
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (b <= nx && nx <= t && l <= ny && ny <= r && passable[nx][ny] && dist[nx][ny] > dist[x][y] + 1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    dq.addLast(DigitUtils.asLong(nx, ny));
                }
            }
        }
        for (int i = L; i <= R; i++) {
            qs[i].ans = Math.min(qs[i].ans, dist[qs[i].ax][qs[i].ay] +
                    dist[qs[i].bx][qs[i].by]);
        }
    }

    private void dac(int b, int t, int l, int r, int L, int R) {
        if (L > R) {
            return;
        }
        if (b == t && l == r) {
            if (passable[b][l]) {
                for (int i = L; i <= R; i++) {
                    qs[i].ans = 0;
                }
            }
            return;
        }
        if (t - b >= r - l) {
            int m = (t + b) / 2;
            for (int i = l; i <= r; i++) {
                process(b, t, l, r, m, i, L, R);
            }
            int bufWpos = 0;
            int qsWpos = L;
            for (int i = L; i <= R; i++) {
                Query q = qs[i];
                if (q.ax < m && q.bx < m) {
                    qs[qsWpos++] = q;
                } else if (q.ax > m && q.bx > m) {
                    buf[bufWpos++] = q;
                }
            }
            System.arraycopy(buf, 0, qs, qsWpos, bufWpos);
            dac(b, m - 1, l, r, L, qsWpos - 1);
            dac(m + 1, t, l, r, qsWpos, qsWpos + bufWpos - 1);
        } else {
            int m = (l + r) / 2;
            for (int i = b; i <= t; i++) {
                process(b, t, l, r, i, m, L, R);
            }
            int bufWpos = 0;
            int qsWpos = L;
            for (int i = L; i <= R; i++) {
                Query q = qs[i];
                if (q.ay < m && q.by < m) {
                    qs[qsWpos++] = q;
                } else if (q.ay > m && q.by > m) {
                    buf[bufWpos++] = q;
                }
            }
            System.arraycopy(buf, 0, qs, qsWpos, bufWpos);
            dac(b, t, l, m - 1, L, qsWpos - 1);
            dac(b, t, m + 1, r, qsWpos, qsWpos + bufWpos - 1);
        }
    }


    static class Query {
        int ax;
        int ay;
        int bx;
        int by;
        int ans;

        public Query(int ax, int ay, int bx, int by, int ans) {
            this.ax = ax;
            this.ay = ay;
            this.bx = bx;
            this.by = by;
            this.ans = ans;
        }
    }
}
