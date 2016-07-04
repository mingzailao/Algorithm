package Fundamentals.DataAbstraction;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by apple on 16/7/2.
 */
public class Ex_1_2_06 {
    public static boolean isCircle(String s1,String s2){
        if (s1.length()==s2.length()&&s1.concat(s1).indexOf(s2)>=0){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args){
        StdOut.print(isCircle("ACTGACG","TGACGAC"));
    }
}
