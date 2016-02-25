package Fundamentals.BasicProgModel;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by apple on 16/2/24.
 */
public class Ex_1_1_07b {
    public static void main(String[] args){
        int sum=0;
        for(int i=1;i<1000;i++){
            for(int j=0;j<i;j++){
                sum++;
            }
        }
        StdOut.println(sum);
    }
}
