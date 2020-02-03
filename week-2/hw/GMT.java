import java.lang.System;

public class GMT{

    public static void main(String[] args) {

        //System.out.print(System.currentTimeMillis());
        double time = System.currentTimeMillis();
        double new_time = time / (1000 * 60 * 60 * 24 * 365.25);
       // System.out.print(new_time);
        double time_days = ((new_time - 50) * 365);
        //System.out.println(time_days);
        double time_hours = ((time_days - 32) * 24);
        System.out.println(time_hours);






    }
}