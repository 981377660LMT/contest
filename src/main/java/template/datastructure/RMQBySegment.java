package template.datastructure;


import template.binary.Log2;
import template.primitve.generated.datastructure.IntegerComparator;

/**
 * O(n) space and pre-compute, O(logn) for query min element in interval
 */
public class RMQBySegment {
    public static final int NIL = Integer.MIN_VALUE;
    int[] data;
    IntegerComparator comp;
    int n;
    int expand;


    private int left(int i) {
        return i << 1;
    }

    private int right(int i) {
        return (i << 1) | 1;
    }

    public RMQBySegment(int n, IntegerComparator comp) {
        this.comp = comp;
        this.n = n;
        expand = 1 << Log2.ceilLog(n);
        data = new int[2 * expand];
        build(0, expand - 1, 1);
    }

    private int merge(int a, int b) {
        if (a == NIL || b == NIL) {
            return a == NIL ? b : a;
        }
        return comp.compare(a, b) < 0 ? a : b;
    }

    private void build(int l, int r, int i) {
        if (l < r) {
            int m = (l + r) >> 1;
            build(l, m, left(i));
            build(m + 1, r, right(i));
            data[i] = merge(data[left(i)], data[right(i)]);
        } else {
            data[i] = l >= n ? NIL : l;
        }
    }

    /**
     * Query the index of minimum elements in interval [l,r]
     */
    public int query(int l, int r) {
        return query(l, r, 0, expand - 1, 1);
    }

    private int query(int ll, int rr, int l, int r, int i) {
        if (ll > r || l > rr) {
            return NIL;
        }
        if (ll <= l && r <= rr) {
            return data[i];
        }
        int m = (l + r) >> 1;
        return merge(query(ll, rr, l, m, left(i)),
                query(ll, rr, m + 1, r, right(i)));
    }
}