package contest;

import template.io.FastInput;
import template.io.FastOutput;
import template.math.DigitUtils;
import template.math.EulerSieve;
import template.primitve.generated.IntegerPreSum;
import template.primitve.generated.IntegerMultiWayStack;
import template.primitve.generated.MultiWayLongDeque;
import template.primitve.generated.MultiWayLongStack;
import template.utils.SortUtils;

import javax.xml.bind.annotation.XmlElementDecl;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DChaoticV {
    int limit = 669;
    Node[] nodes;
    int n;

    public void solve(int testNumber, FastInput in, FastOutput out) {
        EulerSieve es = new EulerSieve(5000);
        nodes = new Node[5000 + 1];
        for (int i = 1; i <= 5000; i++) {
            nodes[i] = new Node();
            nodes[i].id = i;
        }

        n = in.readInt();
        for (int i = 1; i <= 5000; i++) {
            for (int j = 0; j < limit; j++) {
                nodes[i].status[j] = countFactor(i, es.get(j));
            }
        }

        for (int i = 0; i < n; i++) {
            int which = in.readInt();
            if(which == 0){
                which = 1;
            }
            nodes[which].weight++;
        }
        rec(nodes.clone(), 1, 5000, limit - 1);
        dfs(nodes[1], null);
        Node center = findCenter(nodes[1], null, nodes[1].size);
        long ans = count(center, null, 0);
        out.println(ans);
    }

    public long count(Node root, Edge p, int depth) {
        long ans = (long)root.weight * depth;
        for (Edge e : root.next) {
            if (e == p) {
                continue;
            }
            Node node = e.other(root);
            ans += count(node, e, depth + e.len);
        }
        return ans;
    }

    public Node findCenter(Node root, Edge p, int total) {
        int maxChild = total - root.size;
        for (Edge e : root.next) {
            if (e == p) {
                continue;
            }
            Node node = e.other(root);
            maxChild = Math.max(maxChild, node.size);
        }
        if (maxChild * 2 <= total) {
            return root;
        }
        for (Edge e : root.next) {
            if (e == p) {
                continue;
            }
            Node node = e.other(root);
            Node ans = findCenter(node, e, total);
            if (ans != null) {
                return ans;
            }
        }
        return null;
    }

    public void dfs(Node root, Edge p) {
        root.size = root.weight;
        for (Edge e : root.next) {
            if (e == p) {
                continue;
            }
            Node node = e.other(root);
            dfs(node, e);
            root.size += node.size;
        }
    }

    public Node rec(Node[] nodes, int l, int r, int k) {
        if (k < 0) {
            return nodes[l];
        }
        Arrays.sort(nodes, l, r + 1, (a, b) -> a.status[k] - b.status[k]);
        Node last = null;
        for (int i = r; i >= l; i--) {
            int j = i;
            while (i - 1 >= l && nodes[i - 1].status[k] == nodes[i].status[k]) {
                i--;
            }
            Node merged = rec(nodes, i, j, k - 1);
            if (last == null) {
                last = merged;
            } else {
                last = merge(last, merged);
            }
        }
        return last;
    }

    public Node merge(Node a, Node b) {
        Node merged = new Node();
        for (int i = limit - 1; i >= 0; i--) {
            if (a.status[i] == b.status[i]) {
                merged.status[i] = a.status[i];
            } else {
                if (a.status[i] > b.status[i]) {
                    Node tmp = a;
                    a = b;
                    b = tmp;
                }
                merged.status[i] = a.status[i];
                int distToA = 0;
                int distToB = b.status[i] - a.status[i];
                for (int j = 0; j < i; j++) {
                    distToA += a.status[j];
                    distToB += b.status[j];
                }
                if (distToA > 0) {
                    addEdge(merged, a, distToA);
                    addEdge(merged, b, distToB);
                    return merged;
                } else {
                    addEdge(a, b, distToB);
                    return a;
                }
            }
        }

        throw new RuntimeException();
    }

    public void addEdge(Node a, Node b, int len) {
        Edge e = new Edge();
        e.a = a;
        e.b = b;
        e.len = len;
        a.next.add(e);
        b.next.add(e);
    }

    public int countFactor(int n, int x) {
        return n <= 0 ? 0 : (n / x + countFactor(n / x, x));
    }
}

class Edge {
    Node a;
    Node b;
    int len;

    Node other(Node x) {
        return a == x ? b : a;
    }
}

class Node {
    List<Edge> next = new ArrayList<>();
    int size;
    int id;
    int weight;

    int[] status = new int[669];

    @Override
    public String toString() {
        return "" + id;
    }
}

