package Fundamentals.AnalysisOfAlgorithm;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * Created by apple on 16/7/4.
 */
public class TwoSumFast {
    public static int count(int[] a){
        int N=a.length;
        Arrays.sort(a);
        int cnt=0;
        for (int i = 0; i < N; i++) {
            if (BinarySearch.indexOf(a,-a[i])>i){
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args){
        int N = 100;
        int a[] = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-1000, 1000);
        }
        System.out.println(count(a));
    }
}
