package Fundamentals.AnalysisOfAlgorithm;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by apple on 16/7/4.
 */
public class ThreeSumFast {
    public static int count(int[] a){
        int N=a.length;
        Arrays.sort(a);
        int cnt=0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j <N ; j++) {
                if (BinarySearch.indexOf(a,-a[i]-a[j])>j){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args){
        int[] a= In.readInts(args[0]);
        StdOut.println(count(a));
    }
}
    //java Fundamentals/AnalysisOfAlgorithm/ThreeSum ~/IdeaProjects/algs4-data/1Kints.txt
    // 70
