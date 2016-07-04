package Fundamentals.BagsQueuesStacks.LinkList;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by apple on 16/2/26.
 */
public class Steque<Item> implements Iterable<Item> {
    private int N;
    private Node first;
    private Node last;
    private class Node{
        Item item;
        Node next;
    }
    public void push(Item item){
        Node oldfirst=first;
        first=new Node();
        first.item=item;
        first.next=oldfirst;
        N++;
    }
    public Item pop(){
        Item item=first.item;
        first=first.next;
        N--;
        return item;
    }
    public void  enqueue(Item item){
        Node oldlast=last;
        last=new Node();
        last.item=item;
        last.next=null;
        if(N==0){
            first=last;
        }
        else {
            oldlast.next=last;
        }
        N++;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node temp = first;
        for (int i = 0; i < N; i++) {
            s.append("[");
            s.append(temp.item);
            s.append("]");
            s.append(",");
            temp = temp.next;
        }
        return s.toString();
    }


    @Override
    public Iterator<Item> iterator() {
        return new StequeIteretor();
    }

    private class StequeIteretor implements Iterator<Item> {
        private Node current=first;
        @Override
        public boolean hasNext() {
            return current.next!=null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return current.next.item;
        }
    }
    public static void main(String[] args) {
        Steque<Integer> s = new Steque<Integer>();
        // s.push(7);
        s.enqueue(3);
        s.enqueue(5);
        s.enqueue(6);
        s.push(2);
        s.push(1);
        s.push(4);
        // System.out.println(s.pop());//4
        // System.out.println(s.pop());//1
        StdOut.println(s);// 4 1 2 3 5 6
    }
}
