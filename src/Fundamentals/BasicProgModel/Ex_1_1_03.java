package Fundamentals.BasicProgModel;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by apple on 16/2/24.
 */
public class Ex_1_1_03 {
    public static void main(String[] args){
        int a=StdIn.readInt();
        int b=StdIn.readInt();
        int c=StdIn.readInt();
        if(a==b&&b==c){
            StdOut.println("equal");
        }
        else{
            StdOut.println("not equal");
        }
    }
}
