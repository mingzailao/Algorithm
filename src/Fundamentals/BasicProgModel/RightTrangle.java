package Fundamentals.BasicProgModel;

import edu.princeton.cs.algs4.StdDraw;

/**
 * Created by apple on 16/6/30.
 */
public class RightTrangle {

    public static void main(String[] args) {
        StdDraw.square(.5, .5, .5);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.line(.5, .5, .9, .5);
        StdDraw.line(.9, .5, .5, .8);
        StdDraw.line(.5, .8, .5, .5);
        StdDraw.circle(.7, .65, .25);
    }
}
