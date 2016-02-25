package Fundamentals.BasicProgModel;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * Created by apple on 16/2/25.
 */
public class Ex_1_1_15 {
    private int[] data;

    public Ex_1_1_15(int m) {
        int[] data=new int[m];
        for(int i=0;i<data.length;i++){
                data[i]= StdRandom.uniform(10);
        }
        this.data=data;

    }

    public Ex_1_1_15(int[] data) {
        this.data = data;
    }

    public static Ex_1_1_15 histogram(Ex_1_1_15 a, int M){
        int[] O=new int[M];
        for(int i=0;i<a.data.length;i++){
            if(a.data[i]>=0&&a.data[i]<=M-1){
                O[a.data[i]]++;
            }
        }
        return new Ex_1_1_15(O);
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    public static void main(String[] args){
        int m=StdIn.readInt();
        Ex_1_1_15 obj=new Ex_1_1_15(m);
        int M=StdIn.readInt();
        Ex_1_1_15 result=Ex_1_1_15.histogram(obj,M);
        StdOut.println(obj.toString());
        StdOut.println(result.toString());
    }
}
