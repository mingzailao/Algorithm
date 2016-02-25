package Fundamentals.DataAbstraction;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by apple on 16/2/25.
 */
public class Accumulator {
    private double total;
    private int N;

    public Accumulator() {
    }
    public void addDataValue(double val){
        N++;
        total+=val;
    }
    public double mean(){
        return total/N;
    }

    @Override
    public String toString() {
        return "Mean ("+N+" values): "+String.format("%7.5f",mean());
    }
    public static void main(String[] args){
        int T=Integer.parseInt(args[0]);
        Accumulator a=new Accumulator();
        for (int t=0;t<T;t++){
            a.addDataValue(StdRandom.random());
        }
        StdOut.println(a);
    }
}
