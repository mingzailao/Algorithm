package Fundamentals.DataAbstraction;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by apple on 16/2/25.
 */
public class VisualAccumulator extends Accumulator {
    private int N;
    private double total;
    public VisualAccumulator(int trails,double max) {
        StdDraw.setXscale(0,trails);
        StdDraw.setYscale(0,max);
        StdDraw.setPenRadius(.005);
    }
    public void addDataValue(double val){
        N++;
        total+=val;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(N,val);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(N,total/N);
    }

    @Override
    public double mean() {
        return super.mean();
    }

    @Override
    public String toString() {
        return super.toString();
    }
    public static void main(String[] args){
        int T=Integer.parseInt(args[0]);
        VisualAccumulator a=new VisualAccumulator(T,1.0);
        for (int t=0;t<T;t++){
            a.addDataValue(StdRandom.random());
        }
        StdOut.println(a);
    }
}
