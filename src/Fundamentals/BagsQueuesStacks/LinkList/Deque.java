package Fundamentals.BagsQueuesStacks.LinkList;

import java.util.Iterator;

/**
 * Created by apple on 16/2/26.
 */
public class Deque<Item> implements Iterable<Item> {
    private int N;
    private Node first;
    private Node last;
    private class Node{
        Node next;
        Node behind;
        Item item;
    }
    public Deque() {

    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public void pushLeft(Item item){
        N++;
        if (isEmpty()){
            Node o=new Node();
            o.item=item;
            o.next=null;
            o.behind=null;
            first=o;
            last=o;
        }
        else {
            Node o = new Node();
            Node oldfirst = first;
            o.item = item;
            o.next = oldfirst;
            oldfirst.behind = o;
            o.behind = null;
            first = o;
        }
    }
    public void pushRight(Item item){
        N++;
        if (isEmpty()){
            Node o=new Node();
            o.item=item;
            o.next=null;
            o.behind=null;
            first=o;
            last=o;

        }
        else {
            Node o=new Node();
            Node oldlast=last;
            o.item=item;
            o.behind=oldlast;
            oldlast.next=o;
            o.next=null;
            last=o;
        }
    }
    public Item popLeft(){
        if (isEmpty())
            throw new RuntimeException("Deque is Empty");
        Item item=first.item;
        first=first.next;
        first.behind=null;
        N--;
        return item;
    }
    public Item popRight(){
        if (isEmpty())
            throw new RuntimeException("Deque is Empty");
        Item item =last.item;
        last=last.behind;
        last.next=null;
        N--;
        return item;
    }
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>{
        private Node current=first;
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {
            Item item=current.item;
            current =current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }

}
