package template.primitve.generated.datastructure;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class IntegerIntervalMap implements Iterable<IntegerIntervalMap.Interval> {
    private int total = 0;
    private TreeMap<Integer, Interval> map = new TreeMap<>();
    private static int inf = Integer.MAX_VALUE / 4;

    private void add(Interval interval) {
        if (interval.length() <= 0) {
            return;
        }
        map.put(interval.l, interval);
        total += interval.length();
    }

    private void remove(Interval interval) {
        map.remove(interval.l);
        total -= interval.length();
    }

    public int mex(int x) {
        Interval floor = floor(x);
        if (floor == null) {
            return x;
        }
        return Math.max(x, floor.r + 1);
    }

    public Integer nextSet(int x) {
        Interval floor = floor(x);
        if (floor != null && floor.r >= x) {
            return x;
        }
        Interval ceil = ceil(x);
        if (ceil == null) {
            return null;
        }
        return ceil.l;
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public Interval last() {
        return map.lastEntry().getValue();
    }

    public Interval first() {
        return map.firstEntry().getValue();
    }

    public int total() {
        return total;
    }

    public int blockCount() {
        return map.size();
    }

    public void and(IntegerIntervalMap map) {
        int l = -inf;
        for (Interval interval : map) {
            remove(l, interval.l);
            l = interval.r;
        }
    }

    public void or(IntegerIntervalMap map) {
        for (Interval interval : map) {
            add(interval.l, interval.r);
        }
    }

    public Interval floor(int x) {
        Map.Entry<Integer, Interval> entry = map.floorEntry(x);
        return entry == null ? null : entry.getValue();
    }

    public Interval ceil(int x) {
        Map.Entry<Integer, Interval> entry = map.ceilingEntry(x);
        return entry == null ? null : entry.getValue();
    }

    public boolean contain(int l, int r) {
        Interval interval = floor(l);
        return interval != null && interval.r >= r;
    }

    @Override
    public Iterator<Interval> iterator() {
        return map.values().iterator();
    }

    /**
     * [l, r)
     */
    public void add(int l, int r) {
        if (l >= r) {
            return;
        }
        Interval interval = new Interval();
        interval.l = l;
        interval.r = r;
        while (true) {
            Map.Entry<Integer, Interval> ceilEntry = map.ceilingEntry(interval.l);
            if (ceilEntry == null || ceilEntry.getValue().l > interval.r) {
                break;
            }
            Interval ceil = ceilEntry.getValue();
            remove(ceil);
            interval.r = Math.max(interval.r, ceil.r);
        }
        while (true) {
            Map.Entry<Integer, Interval> floorEntry = map.floorEntry(interval.l);
            if (floorEntry == null || floorEntry.getValue().r < interval.l) {
                break;
            }
            Interval floor = floorEntry.getValue();
            remove(floor);
            interval.l = Math.min(interval.l, floor.l);
            interval.r = Math.max(interval.r, floor.r);
        }
        add(interval);
    }

    public void remove(int l, int r) {
        if (l >= r) {
            return;
        }
        while (true) {
            Map.Entry<Integer, Interval> ceilEntry = map.ceilingEntry(l);
            if (ceilEntry == null || ceilEntry.getValue().l >= r) {
                break;
            }
            Interval ceil = ceilEntry.getValue();
            remove(ceil);
            ceil.l = r;
            add(ceil);
        }
        while (true) {
            Map.Entry<Integer, Interval> floorEntry = map.floorEntry(l);
            if (floorEntry == null || floorEntry.getValue().r <= l) {
                break;
            }
            Interval floor = floorEntry.getValue();
            remove(floor);
            if (floor.r > r) {
                Interval left = floor;
                Interval right = new Interval();
                right.l = r;
                right.r = left.r;
                left.r = l;
                add(left);
                add(right);
                break;
            }
            floor.r = l;
            add(floor);
        }
    }

    /**
     * [l, r)
     */
    public static class Interval {
        public int l;
        public int r;

        public int length() {
            return r - l;
        }

        @Override
        public String toString() {
            return "[" + l + "," + r + ")";
        }
    }

    @Override
    public String toString() {
        return map.values().toString();
    }

    public void clear() {
        map.clear();
        total = 0;
    }
}
