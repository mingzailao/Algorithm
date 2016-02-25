package Fundamentals.DataAbstraction;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by apple on 16/2/25.
 */
public class Flips {
    public static void main(String[] args){
        int T=Integer.parseInt(args[0]);
        Counter head=new Counter("heads");
        Counter tails=new Counter("tails");
        for (int t=0;t<T;t++){
            if(StdRandom.bernoulli(0.5)){
                head.increment();
            }
            else
                tails.increment();

        }
        StdOut.println(head);
        StdOut.println(tails);
        int d=head.tally()-tails.tally();
        StdOut.println("delta: "+Math.abs(d));
    }
}
