package Fundamentals.BagsQueuesStacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by apple on 16/2/25.
 */
public class FixedCapacityStack<Item> {
    private Item[] a;
    private int N;
    private final int Max;

    public FixedCapacityStack(int cap) {
        a=(Item[]) new Object[cap];
        Max=cap;
    }

    public void push(Item item){
        a[N++]=item;
    }
    public Item pop(){
        return  a[--N];
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public static void main(String[] args){
        FixedCapacityStack<String> s;
        s=new FixedCapacityStack<String>(100);
        while(!StdIn.isEmpty()){
            String item=StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty())
                StdOut.print(s.pop()+" ");
        }
        StdOut.println("("+s.size()+" left on stack");
    }
//    java-algs4 Fundamentals.BagsQueuesStacks.FixedCapacityStack < ~/IdeaProjects/algs4-data/tobe.txt
//    to be not that or be (2 left on stack

}
