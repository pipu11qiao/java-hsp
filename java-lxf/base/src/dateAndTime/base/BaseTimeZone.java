package dateAndTime.base;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.TimeZone;

public class BaseTimeZone {
    public static  void base(){

        TimeZone tzDefault = TimeZone.getDefault();
        TimeZone tzGMT9 = TimeZone.getTimeZone("GMT+09:00");
        TimeZone tzNY = TimeZone.getTimeZone("America/New_York");

        System.out.println(tzDefault.getID());
        System.out.println(tzGMT9.getID());
        System.out.println(tzNY.getID());

        String[] ids =  TimeZone.getAvailableIDs();
        System.out.println(Arrays.toString(ids));
    }
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();

        c.clear();

        c.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));

        c.set(2019,10,20,8,15,0);
        var sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));

        System.out.println(sdf.format(c.getTime()));

    }
}
