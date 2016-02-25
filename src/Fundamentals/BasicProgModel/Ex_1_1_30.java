package Fundamentals.BasicProgModel;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by apple on 16/2/25.
 */
public class Ex_1_1_30 {
    private boolean[][] a;

    public Ex_1_1_30(int N) {
        boolean[][] a=new boolean[N][N];
        for (int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                a[i][j]=f(i,j);
            }
        }
        this.a=a;
    }
    public static int gcd(int p,int q){
        if(q==0){
            return p;
        }
        int r=p%q;
        return gcd(q,r);
    }
    public static boolean f(int i,int j){
        if(gcd(i,j)==1){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        String s="";
        int m=a.length;
        for(int i=0;i<m;i++){
            s=s+Arrays.toString(a[i])+"\n";
        }
        return s;
    }
    public static void main(String[] args){
        Ex_1_1_30 obj=new Ex_1_1_30(10);
        StdOut.println(obj.toString());
    }
}
