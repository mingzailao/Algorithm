package Fundamentals.BagsQueuesStacks;

import Fundamentals.BagsQueuesStacks.LinkList.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created by apple on 16/2/26.
 */
public class StackInstance {
    public static Stack<String> copy(Stack<String> stack){
        Stack<String> o=new Stack<String>();
        Iterator<String> i = stack.iterator();
        while (i.hasNext()){
            o.push(i.next());
        }
        return o;
    }
    public static void main(String[] args){
        Stack<String> obj =new Stack<String>();
        obj.push("one");
        obj.push("two");
        Stack<String> obj2=copy(obj);
        while (!obj2.isEmpty()){
            StdOut.println(obj2.pop());
        }
    }
}
