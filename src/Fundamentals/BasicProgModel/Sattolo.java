package Fundamentals.BasicProgModel;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by apple on 16/6/30.
 */
public class Sattolo {

    // this class should not be instantiated
    private Sattolo() { }

    /**
     * Rearranges an array of objects to be a uniformly random cycle
     * (under the assumption that <tt>Math.random()</tt> generates independent
     * and uniformly distributed numbers between 0 and 1).
     * @param a the array to be rearranged
     * @see StdRandom
     */
    public static void cycle(Object[] a) {
        int N = a.length;
        for (int i = N; i > 1; i--) {
            // choose index uniformly in [0, i-1)
            int r = (int) (Math.random() * (i-1));
            Object swap = a[r];
            a[r] = a[i-1];
            a[i-1] = swap;
        }
    }

    /**
     * Reads in a sequence of strings from standard input, shuffles
     * them, and prints out the results.
     */
    public static void main(String[] args) {

        // read in the data
        String[] a = StdIn.readAllStrings();

        // shuffle the array
        Sattolo.cycle(a);

        // print results.
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
    }
}