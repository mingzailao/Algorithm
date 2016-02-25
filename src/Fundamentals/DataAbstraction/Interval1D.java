package Fundamentals.DataAbstraction;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

public class Interval1D {

    /**
     * Compares two intervals by left endpoint.
     */
    public static final Comparator<Interval1D> LEFT_ENDPOINT_ORDER  = new LeftComparator();

    /**
     * Compares two intervals by right endpoint.
     */
    public static final Comparator<Interval1D> RIGHT_ENDPOINT_ORDER = new RightComparator();

    /**
     * Compares two intervals by length.
     */
    public static final Comparator<Interval1D> LENGTH_ORDER = new LengthComparator();

    private final double left;
    private final double right;

    /**
     * Initializes a closed interval [left, right].
     *
     * @param  left the left endpoint
     * @param  right the right endpoint
     * @throws IllegalArgumentException if the left endpoint is greater than the right endpoint
     * @throws IllegalArgumentException if either <tt>left</tt> or <tt>right</tt>
     *         is <tt>Double.NaN</tt>, <tt>Double.POSITIVE_INFINITY</tt> or
     *         <tt>Double.NEGATIVE_INFINITY</tt>

     */
    public Interval1D(double left, double right) {
        if (Double.isInfinite(left) || Double.isInfinite(right))
            throw new IllegalArgumentException("Endpoints must be finite");
        if (Double.isNaN(left) || Double.isNaN(right))
            throw new IllegalArgumentException("Endpoints cannot be NaN");

        // convert -0.0 to +0.0
        if (left == 0.0) left = 0.0;
        if (right == 0.0) right = 0.0;

        if (left <= right) {
            this.left  = left;
            this.right = right;
        }
        else throw new IllegalArgumentException("Illegal interval");
    }

    /**
     * Returns the left endpoint of this interval.
     *
     * @return the left endpoint of this interval
     */
    public double left() {
        return left;
    }

    /**
     * Returns the right endpoint of this interval.
     * @return the right endpoint of this interval
     */
    public double right() {
        return right;
    }

    /**
     * Returns true if this interval intersects the specified interval.
     *
     * @param  that the other interval
     * @return <tt>true</tt> if this interval intersects the argument interval;
     *         <tt>false</tt> otherwise
     */
    public boolean intersects(Interval1D that) {
        if (this.right < that.left) return false;
        if (that.right < this.left) return false;
        return true;
    }

    /**
     * Returns true if this interval contains the specified value.
     *
     * @param x the value
     * @return <tt>true</tt> if this interval contains the value <tt>x</tt>;
     *         <tt>false</tt> otherwise
     */
    public boolean contains(double x) {
        return (left <= x) && (x <= right);
    }

    /**
     * Returns the length of this interval.
     *
     * @return the length of this interval (right - left)
     */
    public double length() {
        return right - left;
    }

    /**
     * Returns a string representation of this interval.
     *
     * @return a string representation of this interval in the form [left, right]
     */
    public String toString() {
        return "[" + left + ", " + right + "]";
    }

    /**
     * Compares this transaction to the specified object.
     *
     * @param  other the other interval
     * @return <tt>true</tt> if this interval equals the other interval;
     *         <tt>false</tt> otherwise
     */
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        Interval1D that = (Interval1D) other;
        return this.left == that.left && this.right == that.right;
    }

    /**
     * Returns an integer hash code for this interval.
     *
     * @return an integer hash code for this interval
     */
    public int hashCode() {
        int hash1 = ((Double) left).hashCode();
        int hash2 = ((Double) right).hashCode();
        return 31*hash1 + hash2;
    }

    // ascending order of left endpoint, breaking ties by right endpoint
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

    // ascending order of length
    private static class LengthComparator implements Comparator<Interval1D> {
        public int compare(Interval1D a, Interval1D b) {
            double alen = a.length();
            double blen = b.length();
            if      (alen < blen) return -1;
            else if (alen > blen) return +1;
            else                  return  0;
        }
    }
    public static void main(String[] args) {
        int N=Integer.parseInt(args[0]);
        Interval1D[] data=new Interval1D[N];
        for(int i=0;i<N;i++){
            double m=StdIn.readDouble();
            double n=StdIn.readDouble();
            data[i]=new Interval1D(m,n);

        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(j!=i&&data[i].intersects(data[j])){
                    StdOut.println(data[i]);
                    break;
                }
            }
        }

    }
}