package contest;



import template.algo.IntBinarySearch;
import template.io.FastInput;
import template.io.FastOutput;
import template.problem.IntervalPickProblem;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class ESegmentsOnTheLine {
    public void solve(int testNumber, FastInput in, FastOutput out) {
        int n = in.readInt();
        int s = in.readInt();
        int m = in.readInt();
        int k = in.readInt();

        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = in.readInt();
        }
        IntervalPickProblem.Interval[] intervals = new IntervalPickProblem.Interval[s];

        for (int i = 0; i < s; i++) {
            intervals[i] = new IntervalPickProblem.Interval(in.readInt() - 1, in.readInt() - 1);
        }
        intervals = IntervalPickProblem.sortAndRemoveUnusedInterval(intervals);



        IntervalPickProblem.Interval[] finalIntervals = intervals;
        IntBinarySearch ibs = new IntBinarySearch() {
            @Override
            public boolean check(int mid) {
                long[] data = new long[n];
                for(int i = 0; i < n; i++){
                    if(a[i] <= mid){
                        data[i] = 1;
                    }
                }
                return IntervalPickProblem.solve(data, finalIntervals, m) >= k;
            }
        };

        int ans = ibs.binarySearch(1, (int) 1e9);
        if(!ibs.check(ans)){
            out.println(-1);
            return;
        }
        out.println(ans);
    }
}

class Interval {
    int l;
    int r;
    int w;
}
