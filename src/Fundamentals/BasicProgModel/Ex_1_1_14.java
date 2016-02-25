package Fundamentals.BasicProgModel;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


/**
 * Created by apple on 16/2/25.
 */
public class Ex_1_1_14 {
    public static int lg(int N){
        if(N==1){
            return 0;
        }
        if(N>1){
            int i=0;
            while(N>1){
                N=N/2;
                i++;
            }
            return i;
        }
        else{
            return -1;
        }
    }
    public static void main(String[] args){
        while(!StdIn.isEmpty()){
            int N=StdIn.readInt();
            StdOut.println(Ex_1_1_14.lg(N));
        }


    }
}
