package template.primitve.generated.datastructure;

public class DoubleVersionArray {
    double[] data;
    int[] version;
    int now;
    double[] def;
    public DoubleVersionArray(int cap) {
        this(cap, null);
    }

    public DoubleVersionArray(int cap, double[] def) {
        data = new double[cap];
        version = new int[cap];
        now = 0;
        this.def = def;
    }

    public void clear() {
        now++;
    }

    public void visit(int i) {
        if (version[i] < now) {
            version[i] = now;
            data[i] = def == null ? 0 : def[i];
        }
    }

    public void set(int i, double v) {
        version[i] = now;
        data[i] = v;
    }

    public double modify(int i, double x) {
        visit(i);
        return data[i] = data[i] + x;
    }

    public double get(int i) {
        visit(i);
        return data[i];
    }

    public double inc(int i) {
        visit(i);
        return ++data[i];
    }

    public double dec(int i) {
        visit(i);
        return --data[i];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            if (version[i] < now) {
                continue;
            }
            builder.append(i).append(':').append(data[i]).append(',');
        }
        if (builder.length() > 0) {
            builder.setLength(builder.length() - 1);
        }
        return builder.toString();
    }
}