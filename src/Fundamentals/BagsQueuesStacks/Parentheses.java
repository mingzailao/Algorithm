package Fundamentals.BagsQueuesStacks;

import Fundamentals.BagsQueuesStacks.LinkList.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by apple on 16/2/25.
 */
public class Parentheses {
    public static void main(String[] args) {
        String line = StdIn.readLine();


        Stack s=new Stack();
        for (int i=0;i<line.length();i++) {
            if (line.charAt(i) == '{' || line.charAt(i) == '(' || line.charAt(i) == '[') {
                s.push(line.charAt(i));
            }
            else if (line.charAt(i) == '}') {
                char c = (char) s.pop();
                if (c != '{') {
                    StdOut.println("false");
                    break;
                }
            }
            else if (line.charAt(i) == ']') {
                char c = (char) s.pop();
                if (c != '[') {
                    StdOut.println("false");
                    break;
                }
            }
            else if (line.charAt(i) == ')') {
                char c = (char) s.pop();
                if (c != '(') {
                    StdOut.println("false");
                    break;
                }
            }
            else
                throw new RuntimeException("Error!!!!!!!!!");


        }
        if (s.isEmpty())
            StdOut.println("true");
        else
            StdOut.println("false");
    }

}
