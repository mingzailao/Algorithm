package Fundamentals.DataAbstraction;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by apple on 16/2/25.
 */
public class Interval2D {
    private final Interval1D x;
    private final Interval1D y;

    /**
     * Initializes a two-dimensional interval.
     * @param x the one-dimensional interval of x-coordinates
     * @param y the one-dimensional interval of y-coordinates
     */
    public Interval2D(Interval1D x, Interval1D y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Does this two-dimensional interval intersect that two-dimensional interval?
     * @param that the other two-dimensional interval
     * @return true if this two-dimensional interval intersects
     *    that two-dimensional interval; false otherwise
     */
    public boolean intersects(Interval2D that) {
        if (!this.x.intersects(that.x)) return false;
        if (!this.y.intersects(that.y)) return false;
        return true;
    }

    /**
     * Does this two-dimensional interval contain the point p?
     * @param p the two-dimensional point
     * @return true if this two-dimensional interval contains the point p; false otherwise
     */
    public boolean contains(Point2D p) {
        return x.contains(p.x())  && y.contains(p.y());
    }

    /**
     * Returns the area of this two-dimensional interval.
     * @return the area of this two-dimensional interval
     */
    public double area() {
        return x.length() * y.length();
    }

    /**
     * Returns a string representation of this two-dimensional interval.
     * @return a string representation of this two-dimensional interval
     *    in the form [xleft, xright] x [yleft, yright]
     */
    public String toString() {
        return x + " x " + y;
    }

    /**
     * Does this interval equal the other interval?
     * @param other the other interval
     * @return true if this interval equals the other interval; false otherwise
     */
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        Interval2D that = (Interval2D) other;
        return this.x.equals(that.x) && this.y.equals(that.y);
    }


    /**
     * Returns an integer hash code for this interval.
     * @return an integer hash code for this interval
     */
    public int hashCode() {
        int hash1 = x.hashCode();
        int hash2 = y.hashCode();
        return 31*hash1 + hash2;
    }

    /**
     * Draws this two-dimensional interval to standard draw.
     */
    public void draw() {
        double xc = (x.left() + x.right()) / 2.0;
        double yc = (y.left() + y.right()) / 2.0;
        StdDraw.rectangle(xc, yc, x.length() / 2.0, y.length() / 2.0);
    }
    // test client
    public static void main(String[] args) {
        int N=Integer.parseInt(args[0]);
        double min=Double.parseDouble(args[1]);
        double max=Double.parseDouble(args[2]);
        Interval2D[] data=new Interval2D[N];
        for(int i=0;i<N;i++){
            double x1=StdRandom.uniform(min,max);
            double x2=StdRandom.uniform(min,max);
            double y1=StdRandom.uniform(min,max);
            double y2=StdRandom.uniform(min,max);
            if(x1>x2){
                double tmp=x1;
                x1=x2;
                x2=tmp;
            }
            if(y1>y2){
                double tmp=y1;
                y1=y2;
                y2=tmp;
            }
            Interval1D a=new Interval1D(x1,x2);
            Interval1D b=new Interval1D(y1,y2);
            data[i]=new Interval2D(a,b);
            data[i].draw();
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