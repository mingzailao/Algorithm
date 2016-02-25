package Fundamentals.DataAbstraction;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by apple on 16/2/25.
 */
public class Ex_1_2_03 {
    public static void main(String[] args){
        String string1="hello";
        String string2=string1;
        string1="world";
        StdOut.println(string1);
        StdOut.println(string2);
    }
}
