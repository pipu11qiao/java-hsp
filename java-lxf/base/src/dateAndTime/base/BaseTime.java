package dateAndTime.base;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Epoch Time 是计算1970年1月1日 道现在经历的秒数。
 * epoch time 也称为时间戳 以秒为单位的整数，以毫秒为单位的整数 以秒为单位的浮点数
 * <p>
 * java中 时间戳通常是用long表示的毫秒数
 */
public class BaseTime {
    public static void dateBase(){
        System.out.println(System.currentTimeMillis());

        Date date = new Date();

        System.out.println(date.getYear() + 1900);
        System.out.println(date.getMonth()+1);
        System.out.println(date.getDate());

        System.out.println(date.toString());
        System.out.println(date.toGMTString());
        System.out.println(date.toLocaleString());
    }
    public static void format(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
    }
    public static void main(String[] args) {
        format();
    }
}
