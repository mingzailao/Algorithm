package Fundamentals.BagsQueuesStacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by apple on 16/7/4.
 */
class FixedCapacityStack1<Item> implements Iterable<Item>{
    private Item[] a;
    private int N;

    public FixedCapacityStack1(int Cap) {
        a=(Item[]) new Object[Cap];
        N=0;
    }

    public int getN() {
        return N;
    }

    public boolean isEmpty(){
        return N==0;
    }
    public void push(Item item){
        a[N++]=item;
    }
    public Item pop(){
        return a[--N];
    }
    public boolean isFull(){
        return N==a.length;
    }

    @Override
    public Iterator<Item> iterator() {
        return new FixedCapacityStackIteretor();
    }

    private class FixedCapacityStackIteretor implements Iterator<Item> {
        int i=0;
        @Override

        public boolean hasNext() {
            return i<a.length;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i++];
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

public class Ex_1_3_01 {
    public static void main(String[] args) {
        FixedCapacityStack1<String> f=new FixedCapacityStack1<String>(10);
        for (String string : args) {
            if (!string.equals("-")) {
                f.push(string);
            }
            else if (!f.isEmpty()) {
                System.out.print(f.pop()+" ");
            }
        }
        System.out.println("是否已满？"+ f.isFull());
        System.out.println("("+f.getN()+" left on stack"+")");
    }
}
