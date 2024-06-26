package template.graph;

import template.binary.Bits;
import template.binary.Log2;
import template.primitve.generated.datastructure.IntToIntegerFunction;

import java.util.Arrays;

public class KthAncestorOnTreeByBinaryLift implements LcaOnTree, DistanceOnTree, KthAncestor {
    public int[][] jump;
    public int log;
    DepthOnTree dot;

    public KthAncestorOnTreeByBinaryLift(int n) {
        log = Log2.floorLog(n);
        jump = new int[log + 1][n];
    }

    public void init(IntToIntegerFunction parents, int n) {
        init(parents, n, null);
    }

    /**
     * -1 for root
     */
    public void init(IntToIntegerFunction parents, int n, DepthOnTree dot) {
        for (int i = 0; i < n; i++) {
            jump[0][i] = parents.apply(i);
        }
        for (int i = 0; i + 1 <= log; i++) {
            for (int j = 0; j < n; j++) {
                jump[i + 1][j] = jump[i][j] == -1 ?
                        -1 : jump[i][jump[i][j]];
            }
        }
        if (dot == null) {
            this.dot = new DepthOnTreeByParent(n, new ParentOnTreeByGivenArray(jump[0]));
        } else {
            this.dot = dot;
        }
    }

    public int kthAncestor(int v, int k) {
        for (int i = log; i >= 0; i--) {
            if (Bits.get(k, i) == 1) {
                v = jump[i][v];
            }
        }
        return v;
    }

    public boolean inSubtree(int u, int v) {
        return dot.depth(u) >= dot.depth(v) && kthAncestor(u, dot.depth(u) - dot.depth(v)) == v;
    }

    public int lca(int a, int b) {
        int depthA = dot.depth(a);
        int depthB = dot.depth(b);
        if (depthA < depthB) {
            b = kthAncestor(b, depthB - depthA);
        }
        if (depthA > depthB) {
            a = kthAncestor(a, depthA - depthB);
        }
        if (a == b) {
            return a;
        }
        for (int i = log; i >= 0; i--) {
            if (jump[i][a] == jump[i][b]) {
                continue;
            }
            a = jump[i][a];
            b = jump[i][b];
        }
        return jump[0][a];
    }

    @Override
    public int distance(int u, int v) {
        return dot.depth(u) + dot.depth(v) - dot.depth(lca(u, v)) * 2;
    }
}
