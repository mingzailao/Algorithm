package Fundamentals.DataAbstraction;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
/**
 * Created by apple on 16/2/25.
 */
public class Whitelist {
    public static void main(String[] args){
        int[] W= In.readInts(args[0]);
        StaticSETofInts set;
        set = new StaticSETofInts(W);
        while(!StdIn.isEmpty()){
            int key=StdIn.readInt();
            if(!set.contains(key))
                StdOut.println(key);
        }
    }
}
