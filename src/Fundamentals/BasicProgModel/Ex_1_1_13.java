package Fundamentals.BasicProgModel;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * Created by mingzailao on 16/2/24.
 */
public class Ex_1_1_13 {
    protected int[][] data;

    public Ex_1_1_13(int m,int n) {
        int[][] data=new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                data[i][j]= StdRandom.uniform(100);
            }
        }
        this.data = data;
    }

    private Ex_1_1_13 Trans(){
        Ex_1_1_13 A=new Ex_1_1_13(data[0].length,data.length);
        for(int i=0;i<A.data.length;i++){
            for(int j=0;j<A.data[0].length;j++){
                A.data[i][j]=data[j][i];
            }
        }
        return A;
    }

    @Override
    public String toString() {
        String s="";
        int m=data.length;
        for(int i=0;i<m;i++){
            s=s+Arrays.toString(data[i])+"\n";
        }
        return s;
    }

    public static void main(String[] args){
        Ex_1_1_13 obj=new Ex_1_1_13(10,12);
        Ex_1_1_13 obj2=obj.Trans();
        StdOut.printf(obj.toString());
        StdOut.printf(obj2.toString());
    }
}
