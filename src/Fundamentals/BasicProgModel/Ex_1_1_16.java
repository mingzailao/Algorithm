package Fundamentals.BasicProgModel;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by apple on 16/2/25.
 */
public class Ex_1_1_16 {
    public static String exR1(int n){
        if(n<=0){
            return "";
        }
        return exR1(n-3)+n+exR1(n-3)+2;
    }
    public static void main(String[] args){
        StdOut.println(exR1(6));
    }
}
