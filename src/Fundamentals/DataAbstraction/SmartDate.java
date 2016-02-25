package Fundamentals.DataAbstraction;

/**
 * Created by apple on 16/2/25.
 */
public class SmartDate extends Date implements Datable  {
    private final boolean reasonable;

    public SmartDate(int month, int day, int year) {
        super(month, day, year);
        if(month>12||month<1){
            this.reasonable=false;
        }
        else if (day>32)
            this.reasonable=false;
        else
        //假设每年每月都是31天.
            this.reasonable=true;
        if (!reasonable){
            throw new RuntimeException("Wrong time!!!!!!");
        }
    }

    @Override
    public int getMonth() {
        return super.getMonth();
    }

    @Override
    public int getDay() {
        return super.getDay();
    }

    @Override
    public int getYear() {
        return super.getYear();
    }
    public String dayOfTheWeek(){
        return "";
    }


}
