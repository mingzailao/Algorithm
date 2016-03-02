package Fundamentals.BagsQueuesStacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by apple on 16/2/26.
 */
public class QueueInstance {
    public static void main(String[] args){
        int k =Integer.parseInt(args[0]);
        Queue<String> queue=new Queue<String>();
        while (!StdIn.isEmpty()){
            String s=StdIn.readString();
            if (queue.size()<k){
                queue.enqueue(s);
            }
            else {
                queue.enqueue(s);
                queue.dequeue();
            }
        }
        StdOut.println(queue.dequeue());
    }
}
