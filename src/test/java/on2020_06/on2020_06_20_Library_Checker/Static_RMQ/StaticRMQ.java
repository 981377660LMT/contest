package on2020_06.on2020_06_20_Library_Checker.Static_RMQ;



import template.datastructure.RMQ;
import template.datastructure.RMQBySegment;
import template.io.FastInput;
import template.io.FastOutput;

public class StaticRMQ {
    public void solve(int testNumber, FastInput in, FastOutput out) {
        int n = in.readInt();
        int q = in.readInt();
        int[] a = new int[n];
        in.populate(a);
        RMQBySegment rmq = new RMQBySegment(n, (x, y) -> Integer.compare(a[x], a[y]));
        for (int i = 0; i < q; i++) {
            int l = in.readInt();
            int r = in.readInt() - 1;
            int min = a[rmq.query(l, r)];
            out.println(min);
        }
    }
}