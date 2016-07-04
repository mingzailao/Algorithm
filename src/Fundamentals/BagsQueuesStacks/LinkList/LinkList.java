package Fundamentals.BagsQueuesStacks.LinkList;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created by apple on 16/2/26.
 */
public class LinkList<Item> implements Iterable<Item> {
    private Node first;//the first node of the linklist;
    private int N;//size of the linklist;
    protected class Node{
        Item item;
        Node next;
    }
    public void push(Item item){
        Node oldFirst=first;
        Node a=new Node();
        a.item=item;
        a.next=oldFirst;
        first=a;
        N++;
    }
    public Item pop(){
        Item item=first.item;
        first=first.next;
        N--;
        return item;
    }
    public void HeadAdd(Item item){
        Node oldfirst=first;
        first.item=item;
        first.next=oldfirst;
        N++;
    }
    public Item HeadDelete(){
        if (first==null){
            throw new RuntimeException("The LinkList is Empty!");
        }
        Item result=first.item;
        first=first.next;
        N--;
        return result;
    }
    public void EndAdd(Item item){
        if (first==null){
            HeadAdd(item);
        }
        else if (first.next==null){
            Node p=new Node();
            p.item=item;
            first.next=p;
            N++;
        }
        else {
            Node work = first;
            while (work.next.next != null) {
                work = work.next;
            }
            Node p = new Node();
            p.item = item;
            work.next.next = p;
            N++;
        }

    }
    public Item EndDelete(){
        if (first==null){
            throw new RuntimeException("The LinkList is Empty!");
        }
        else if (first.next==null){
            return HeadDelete();
        }
        else {
            Node work=first;
            while (work.next.next!=null){
                work=work.next;
            }
            Item o=work.next.item;
            work.next=null;
            N--;
            return o;
        }
    }
    public Item delete(int k){
        if (k>N){
            throw new RuntimeException("k must less than the lenth of the linklist!");
        }
        if (k==N){
            return EndDelete();
        }
        if (k==1)
            return HeadDelete();
        else if (k==2){
            Item o=first.next.item;
            first.next=first.next.next;
            N--;
            return o;
        }
        else {
            Node work=first;
            for (int i = 0; i < k-3; i++) {
                work=work.next;
            }
            Item o=work.next.next.item;
            work.next.next=work.next.next.next;
            N--;
            return o;
        }

    }
    public boolean find(LinkList<Item> list,Item key){
        if (list.first.item.equals(key)){
            return true;
        }
        Iterator<Item> i=list.iterator();
        while (i.hasNext()){
            if (i.next().equals(key)){
                return true;
            }
        }
        return false;
    }
    public void removeAfter(Node node){
        if (node!=null){
            node.next=null;
        }
    }
    public void insertAfter(Node node1,Node node2){
        if (node1!=null||node2!=null)
            node1.next=node2;
    }
    public  void remove(LinkList<Item> linklist,String key){
        if (linklist.getN()==1){
            if (linklist.first.item.equals(key)){
                first=null;
                N--;
            }
        }
        else if (linklist.getN()==2){
            if (linklist.first.item.equals(key)){
                first=first.next;
                N--;
            }
            if (linklist.first.next.item.equals(key)){
                first.next=null;
                N--;
            }
        }
        else {
            if (linklist.first.item.equals(key)){
                first=first.next;
                N--;
            }
            else if (linklist.first.next.item.equals(key)){
                first.next=null;
                N--;
            }
            Node work=linklist.first;
            if(work.next.next.item.equals(key)){
                work.next.next=work.next.next.next;
                N--;
            };
            while (work.next.next!=null){
                if(work.next.next.item.equals(key)){
                    work.next.next=work.next.next.next;
                    N--;
                }
                work=work.next;
            }


        }
    }
    public int getN() {
        return N;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {

        private Node current=first;
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {
            Item item=current.item;
            current=current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }
    public int max(LinkList<Integer> l){
        int max=0;
        for (int item :
                l) {
            if (max < item){
                max=item;
            }
        }
        return max;
    }
    public static void main(String[] args){
        LinkList<Integer> linkListA=new LinkList<Integer>();
        for (int i = 0; i < 10; i++) {
            linkListA.push(i);
        }
        linkListA.delete(1);
        Iterator<Integer> i=linkListA.iterator();
        while (i.hasNext()){
            int item=i.next();
            StdOut.println(item);
        }//8,7,6,5,4,3,2,1,0
        StdOut.println(linkListA.find(linkListA,2));//true
        StdOut.println(linkListA.find(linkListA,9));//false

        linkListA.removeAfter(linkListA.first.next.next.next.next.next.next);
        for (int item :
                linkListA) {
            StdOut.println(item);
        }
        linkListA.insertAfter(linkListA.first,linkListA.first.next.next);
        for (int item :
                linkListA) {
            StdOut.println(item);
        }
        linkListA.delete(1);
        StdOut.println(linkListA.max(linkListA));

    }
}
