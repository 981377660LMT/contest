package template.geometry.geo2;

import template.utils.GeoConstant;
import template.utils.SequenceUtils;

import java.util.*;

public class ConvexHull2 {

    public static Collection<Point2> grahamScan(List<Point2> pointPolygon, boolean includeSameLine) {
        if (pointPolygon.size() <= 1) {
            return pointPolygon;
        }

        final Point2[] points = pointPolygon.toArray(new Point2[0]);
        int n = points.length;
        for (int i = 1; i < n; i++) {
            int cmp = Point2.SORT_BY_XY.compare(points[i], points[0]);
            if (cmp >= 0) {
                continue;
            }
            SequenceUtils.swap(points, 0, i);
        }

        Point2 first = points[0];
        Comparator<Point2> cmpByPolarAngle = Point2.sortByPolarAngleAround(first);
        Arrays.sort(points, 1, n, cmpByPolarAngle.thenComparingDouble(x -> Point2.dist2(first, x)));

        if (!includeSameLine) {
            int shrinkSize = 2;
            for (int i = 2; i < n; i++) {
                if (cmpByPolarAngle.compare(points[i], points[shrinkSize - 1]) == 0) {
                    points[shrinkSize - 1] = points[i];
                } else {
                    points[shrinkSize++] = points[i];
                }
            }
            n = shrinkSize;
        } else {
            int r = n - 1;
            int l = r;
            while (l - 1 > 0 && cmpByPolarAngle.compare(points[l], points[l - 1]) == 0) {
                l--;
            }
            SequenceUtils.reverse(points, l, r);
        }

        Deque<Point2> stack = new ArrayDeque<>(n);
        stack.addLast(points[0]);
        for (int i = 1; i < n; i++) {
            while (stack.size() >= 2) {
                Point2 last = stack.removeLast();
                Point2 second = stack.peekLast();
                int sign = GeoConstant.sign(Point2.cross(second, points[i], last));
                if (sign < 0 || includeSameLine && sign == 0) {
                    stack.addLast(last);
                    break;
                }
            }
            stack.addLast(points[i]);
        }

        return stack;
    }

    public static Point2[] theFarthestPointPair(Point2[] convexHull) {
        // 旋转卡壳
        int n = convexHull.length;

        if (n <= 2) {
            return new Point2[]{convexHull[0 % n], convexHull[1 % n]};
        }

        Point2[] ab = new Point2[2];
        Point2[] cd = new Point2[]{convexHull[1 % n], convexHull[2 % n]};

        Point2 x = cd[0];
        Point2 y = cd[1];
        double farthestDist2 = 0;
        for (int i = 0, j = 1; i < n; i++) {
            ab[0] = convexHull[i % n];
            ab[1] = convexHull[(i + 1) % n];
            while (GeoConstant.sign(GeoConstant.cross(ab[1].x - ab[0].x, ab[1].y - ab[0].y, cd[1].x - cd[0].x, cd[1].y - cd[0].y)) >= 0
                    && GeoConstant.sign(GeoConstant.cross(ab[1].x - ab[0].x, ab[1].y - ab[0].y, convexHull[(j + 2) % n].x - cd[1].x, convexHull[(j + 2) % n].y - cd[1].y)) >= 0) {
                j++;
                cd[0] = cd[1];
                cd[1] = convexHull[(j + 1) % n];
            }
            for (int k = 0; k < 2; k++) {
                for (int t = 0; t < 2; t++) {
                    double dist2 = Point2.dist2(ab[k], cd[t]);
                    if (farthestDist2 >= dist2) {
                        continue;
                    }
                    x = ab[k];
                    y = cd[t];
                    farthestDist2 = dist2;
                }
            }
        }

        return new Point2[]{x, y};
    }


}
