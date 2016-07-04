package Fundamentals.AnalysisOfAlgorithm;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * Created by apple on 16/7/4.
 */
public class FourSumFast {
    public static int count(int a[]) {
        int N = a.length;
        Arrays.sort(a);
        int cun = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (BinarySearch.indexOf(a, -a[i] - a[j] - a[k]) > k) {
                        cun++;
                    }
                }
            }
        }

        return cun;
    }

    public static void main(String[] args) {
        int N = 100;
        int a[] = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-1000, 1000);
        }
        System.out.println(count(a));
    }
}
