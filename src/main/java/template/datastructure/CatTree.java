package template.datastructure;

import template.math.Bits;
import template.math.CachedLog2;

public class CatTree<S, E> {
    public CatTree(E[] data, int len, SetHandler<S, E> handler) {
        this.handler = handler;
        int level = CachedLog2.ceilLog(len) + 1;
        levels = new Object[level][len];
        for (int i = 0; i < len; i++) {
            levels[0][i] = handler.makeSet(data[i]);
        }
        build(data, len, level - 1);
    }

    public S query(int l, int r) {
        if (l == r) {
            return (S) levels[0][l];
        }
        int level = Bits.theFirstDifferentIndex(l, r) + 1;
        return handler.mergeSet((S) levels[level][l], (S) levels[level][r]);
    }

    private void build(E[] data, int len, int level) {
        if (level <= 0) {
            return;
        }
        build(data, len, level - 1);

        int bit = level - 1;
        int mask = (1 << bit) - 1;
        int step = 1 << level;

        for (int i = mask; i < len; i += step) {
            levels[level][i] = levels[0][i];
            for (int j = i - 1; (j & mask) != mask; j--) {
                levels[level][j] = handler.insertLeft(data[j], (S) levels[level][j + 1]);
            }
            if (i + 1 >= len) {
                continue;
            }
            levels[level][i + 1] = levels[0][i + 1];
            for (int j = i + 2; j < len && (j & mask) != 0; j++) {
                levels[level][j] = handler.insertRight((S) levels[level][j - 1], data[j]);
            }
        }
    }

    public static interface SetHandler<S, E> {
        S insertLeft(E element, S set);

        S insertRight(S set, E element);

        S makeSet(E element);

        S mergeSet(S a, S b);
    }

    Object[][] levels;
    private SetHandler<S, E> handler;
}