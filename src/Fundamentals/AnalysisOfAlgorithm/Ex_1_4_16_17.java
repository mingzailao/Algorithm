package Fundamentals.AnalysisOfAlgorithm;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * Created by apple on 16/7/4.
 */
public class Ex_1_4_16_17 {
    //最近的一对
    public static String approach(double a[]) {
        Arrays.sort(a);
        double temp = 100000;
        int index = -1;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i + 1] - a[i] < temp) {
                temp = a[i + 1] - a[i];
                index = i;
            }
        }
        return "min:" + temp + " index:" + index + "," + (index + 1);
    }

    //最远的一对
    public static String distant(double a[]) {

        Arrays.sort(a);
        double temp = -100000.0;
        int index = -1;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i + 1] - a[i] > temp) {
                temp = a[i + 1] - a[i];
                index = i;
            }
        }
        return "max:" + temp + " index:" + index + "," + (index + 1);
    }

    public static void main(String[] args) {
//		 double a[]={1.0,4.0,2.0,15.0,7.0};
//		 System.out.println(approach(a)); //min:1.0    0,1
//		 System.out.println(distant(a));  // max:8.0   3,4

        int N = 100;
        double b[] = new double[N];
        for (int i = 0; i < N; i++) {
            b[i] = StdRandom.uniform(10.2, 1000.8);
        }
        System.out.println(approach(b));
        System.out.println(distant(b));
    }


}
