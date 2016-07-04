package Fundamentals.BagsQueuesStacks;

import Fundamentals.BagsQueuesStacks.LinkList.*;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by apple on 16/7/2.
 */
public class Reverse {
    public static void main(String[] args){
        Fundamentals.BagsQueuesStacks.LinkList.Stack<Integer> stack=new Fundamentals.BagsQueuesStacks.LinkList.Stack<Integer>();
        while (!StdIn.isEmpty()){
            stack.push(StdIn.readInt());
        }
        for (int i :
                stack) {
            StdOut.println(i);
        }
    }
}
