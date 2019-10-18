package template;

import java.util.Arrays;

public class DoubleList {
    private int size;
    private int cap;
    private double[] data;
    private static final double[] EMPTY = new double[0];

    public DoubleList(int cap) {
        this.cap = cap;
        if (cap == 0) {
            data = EMPTY;
        } else {
            data = new double[cap];
        }
    }

    public DoubleList(DoubleList list) {
        this.size = list.size;
        this.cap = list.cap;
        this.data = Arrays.copyOf(list.data, size);
    }

    public DoubleList() {
        this(0);
    }

    private void ensureSpace(int need) {
        int req = size + need;
        if (req > cap) {
            while (cap < req) {
                cap = Math.max(cap + 10, 2 * cap);
            }
            data = Arrays.copyOf(data, cap);
        }
    }

    private void checkRange(int i) {
        if (i < 0 || i >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public double[] toArray() {
        return Arrays.copyOf(data, size);
    }

    public double[] toArray(double[] arr) {
        if (arr.length < size) {
            arr = new double[size];
        }
        System.arraycopy(data, 0, arr, 0, size);
        return arr;
    }

    public double get(int i) {
        checkRange(i);
        return data[i];
    }

    public void add(double x) {
        ensureSpace(1);
        data[size++] = x;
    }

    public void set(int i, double x){
        checkRange(i);
        data[i] = x;
    }

    public void expandWith(double x, int len) {
        ensureSpace(len - size);
        while (size < len) {
            add(x);
        }
    }

    public void addAll(double[] x, int offset, int len) {
        ensureSpace(len);
        System.arraycopy(x, offset, data, size, len);
        size += len;
    }

    public void addAll(DoubleList list) {
        addAll(list.data, 0, list.size);
    }

    public int indexOf(double x) {
        for (int i = 0; i < size; i++) {
            if (x == data[i]) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(double x) {
        for (int i = size - 1; i >= 0; i--) {
            if (x == data[i]) {
                return i;
            }
        }
        return -1;
    }

    public void sort() {
        Randomized.randomizedArray(data, 0, size);
        Arrays.sort(data, 0, size);
    }

    public int binarySearch(double x) {
        return Arrays.binarySearch(data, 0, size, x);
    }

    public void push(double x) {
        add(x);
    }

    public double pop() {
        return data[--size];
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        checkRange(index);
        if (index == size - 1) {
            pop();
            return;
        }
        System.arraycopy(data, index + 1, data, index, size - index);
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
    }

    public String toString() {
        return Arrays.toString(Arrays.copyOf(data, size));
    }
}