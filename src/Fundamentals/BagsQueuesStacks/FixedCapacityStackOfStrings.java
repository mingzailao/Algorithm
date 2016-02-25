package Fundamentals.BagsQueuesStacks;

/**
 * Created by apple on 16/2/25.
 */
public class FixedCapacityStackOfStrings {
    private String[] a;
    private int N;
    private final int Max;

    public FixedCapacityStackOfStrings(int cap) {
        a=new String[cap];
        Max=cap;
    }
    public void push(String item){
        a[N++]=item;
    }
    public String pop(){
        return a[--N];
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public boolean isFull(){
        if(N==Max)
            return true;
        else
            return false;
    }
    public static void main(String[] args){

    }
}
