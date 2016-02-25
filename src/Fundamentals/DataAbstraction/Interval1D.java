package Fundamentals.DataAbstraction;

import edu.princeton.cs.algs4.StdIn;

import java.util.Comparator;

public class Interval1D {
    public static final Comparator<Interval1D> LEFT_ENDPOINT_ORDER  = new LeftComparator();
    public static final Comparator<Interval1D> RIGHT_ENDPOINT_ORDER = new RightComparator();
    public static final Comparator<Interval1D> LENGTH_ORDER         = new LengthComparator();

    private final double left;
    private final double right;

    public Interval1D(double left, double right) {
        if (left <= right) {
            this.left  = left;
            this.right = right;
        }
        else throw new RuntimeException("Illegal interval");
    }

    // does this interval intersect that one?
    public boolean intersects(Interval1D that) {
        if (this.right < that.left) return false;
        if (that.right < this.left) return false;
        return true;
    }

    // does this interval contain x?
    public boolean contains(double x) {
        return (left <= x) && (x <= right);
    }

    // length of this interval
    public double length() {
        return left - right;
    }

    // string representation of this interval
    public String toString() {
        return "[" + left + ", " + right + "]";
    }



    private static class LeftComparator implements Comparator<Interval1D> {
        public int compare(Interval1D a, Interval1D b) {
            if      (a.left  < b.left)  return -1;
            else if (a.left  > b.left)  return +1;
            else if (a.right < b.right) return -1;
            else if (a.right > b.right) return +1;
            else                        return  0;
        }
    }

    // ascending order of right endpoint, breaking ties by left endpoint
    private static class RightComparator implements Comparator<Interval1D> {
        public int compare(Interval1D a, Interval1D b) {
            if      (a.right < b.right) return -1;
            else if (a.right > b.right) return +1;
            else if (a.left  < b.left)  return -1;
            else if (a.left  > b.left)  return +1;
            else                        return  0;
        }
    }

    // ascending order of left endpoint, breaking ties by right endpoint
    private static class LengthComparator implements Comparator<Interval1D> {
        public int compare(Interval1D a, Interval1D b) {
            double alen = a.length();
            double blen = b.length();
            if      (alen < blen) return -1;
            else if (alen > blen) return +1;
            else                  return  0;
        }
    }




    // test client
    public static void main(String[] args) {
        int N=Integer.parseInt(args[0]);
        Interval1D[] data=new Interval1D[N];
        for(int i=0;i<N;i++){
            double m=StdIn.readDouble();
            double n=StdIn.readDouble();
            data[i]=new Interval1D(m,n);
        }
    }
}