package Fundamentals.DataAbstraction;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by apple on 16/2/25.
 */
public class Date implements Datable {
    private final int month;
    private final int day;
    private final int year;

    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }


    @Override
    public String toString() {
        return getMonth()+"/"+getDay()+"/"+getYear();
    }
    public boolean equals(Object x){
        if (this==x)
            return true;
        if (x==null)
            return false;
        if(this.getClass()!=x.getClass())
            return false;
        Date that=(Date) x;
        if(this.day!=that.day)
            return false;
        if (this.month!=that.month)
            return false;
        if (this.year!=that.year)
            return false;
        return true;
    }
    public static void main(String[] args){
        int m=Integer.parseInt(args[0]);
        int d=Integer.parseInt(args[1]);
        int y=Integer.parseInt(args[2]);
        Date date=new Date(m,d,y);
        StdOut.println(date);

    }
}
