package Fundamentals.BasicProgModel;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by apple on 16/2/24.
 */
public class Ex_1_1_05 {
    public static void main(String[] args){
        double x= StdIn.readDouble();
        double y=StdIn.readDouble();
        if(x>0&&x<1&&y<1&&y>0){
            StdOut.println("true");
        }
        else {
            StdOut.println("false");
        }
    }
}
