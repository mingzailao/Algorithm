package Fundamentals.BasicProgModel;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by apple on 16/2/24.
 */
public class Average {
    public static void main(String[] args){
        double sum=0.0;
        int cnt=0;
        while(!StdIn.isEmpty()){
            sum+=StdIn.readDouble();
            cnt++;
        }
        double avg=sum/cnt;
        StdOut.printf("Fundamentals.BasicProgModel.Average is %.5f\n",avg);
    }
}
