package Fundamentals.BasicProgModel;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by apple on 16/2/24.
 */
public class Shuffle {
    public static void main(String[] args) {

        // read in the data
        String[] a = StdIn.readAll().split("\\s+");
        int N = a.length;

        // shuffle
        for (int i = 0; i < N; i++) {
            // int from remainder of deck
            int r = i + (int) (Math.random() * (N - i));
            String swap = a[r];
            a[r] = a[i];
            a[i] = swap;
        }

        // print permutation
        for (int i = 0; i < N; i++)
            StdOut.println(a[i]);
    }
}
