package Fundamentals.BagsQueuesStacks.LinkList;

/**
 * Created by apple on 16/7/4.
 */
public class Ex_1_3_21<T> {
    private int N;
    private Node first;
    private Node last;

    private class Node {
        T item;
        Node next;
    }

    public void enqueue(T item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (N == 0) {
            first = last;
        } else {
            oldlast.next = last;
        }
        N++;
    }

    boolean find(T key) {
        for (Node x = first; x != null; x = x.next) {
            if (x.item == key) {
                return true;
            }
        }
        return false;

    }
    void removeAfter(T key){
        for(Node x=first;x!=null;x=x.next){
            if (x.item==key) {
                x.next=null;
            }
        }
    }



    public static void main(String[] args) {
        Ex_1_3_21<Integer> a= new Ex_1_3_21<Integer>();
        for (int i = 0; i < 5; i++) {
            a.enqueue(i);
        }
        System.out.println(a.find(2));//true
        a.removeAfter(1);
        System.out.println(a.find(2));//false
    }

}
