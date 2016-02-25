package Fundamentals.BasicProgModel;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by apple on 16/2/24.
 */
public class Ex_1_1_11 {
    private boolean[][] data;
    public Ex_1_1_11(int m,int n) {
        boolean[][] data=new boolean[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                data[i][j]= StdRandom.bernoulli(0.5);
            }
        }
        this.data=data;
    }

    public static void main(String[] args){
        Ex_1_1_11 A=new Ex_1_1_11(4,5);
        for(int i=0;i<A.data.length;i++){
            for(int j=0;j<A.data[0].length;j++){
                if(A.data[i][j]){
                    StdOut.print("*");
                }
                else{
                    StdOut.print(" ");
                }
            }
            StdOut.println();
        }
    }
}
