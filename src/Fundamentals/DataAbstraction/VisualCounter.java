package Fundamentals.DataAbstraction;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

/**
 * Created by apple on 16/2/25.
 */
public class VisualCounter  {
    private int count;
    private int N=0;
    private final int max;

    public VisualCounter(int N,int max) {
        this.N=N;
        this.max=max;
        StdDraw.setXscale(0,N);
        StdDraw.setYscale(0,0.5);
        StdDraw.setPenRadius(.005);
    }
    public void increment(){
        if(count<max-1){
            count++;
            StdDraw.setPenColor(StdDraw.DARK_GRAY);
            StdDraw.point(N,count);
        }
    }
    public void decrement(){
        if (count>-max+1)
            count--;
            StdDraw.setPenColor(StdDraw.DARK_GRAY);
            StdDraw.point(N,count);
    }
    public static void main(String[] args){
        int N=Integer.parseInt(args[0]);
        int max=Integer.parseInt(args[1]);
        VisualCounter obj=new VisualCounter(N,max);
        for(int t=0;t<N;t++){
            if(StdIn.readInt()==1)
                obj.increment();
            else if (StdIn.readInt()==-1)
                obj.decrement();
            else
                break;
        }
    }
}
