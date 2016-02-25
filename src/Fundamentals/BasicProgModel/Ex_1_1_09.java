package Fundamentals.BasicProgModel;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by apple on 16/2/24.
 */
public class Ex_1_1_09 {
    public static void main(String[] args){
        int N= StdIn.readInt();
        String s="";
        for(int n=N;n>0;n/=2){
            s=(n%2+s);
        }
        StdOut.println(s);
    }
}
