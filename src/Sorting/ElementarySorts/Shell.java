package Sorting.ElementarySorts;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by apple on 16/2/26.
 */
public class Shell {
    public static void sort(Comparable[] a){
        int N=a.length;
        int h=1;
        while (h<N/3){
            h=3*h+1;
        }
        while (h>=1){
            for (int i=h;i<N;i++){
                for (int j=i;j>=h&&less(a[j],a[j-h]);j-=h){
                    exch(a,j,j-h);
                }
            }
            h=h/3;
        }
    }
    public static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    private static void exch(Comparable[] a,int i,int j){
        Comparable t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
    private static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i]+" ");
        }
        StdOut.println();
    }
    public static boolean isSorted(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            if (less(a[i],a[i-1]))
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        String[] a= In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}