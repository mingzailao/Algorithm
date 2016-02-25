package Fundamentals.BasicProgModel;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by apple on 16/2/24.
 */
public class Ex_1_1_07a {
    public static void main(String[] args){
        double t=9.0;
        while(Math.abs(t-9.0/t)>0.01){
            t=(9.0/t+t)/2.0;
        }
        StdOut.printf("%.5f\n",t);
    }
}
