package Fundamentals.BasicProgModel;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by apple on 16/2/24.
 */
public class Ex_1_1_07c {
    public static void main(String[] args){
        int sum=0;
        for(int i=1;i<1000;i*=2){
            for (int j=0;j<1000;j++){
                sum++;
            }
        }
        StdOut.println(sum);
    }
}
