package dateAndTime.base;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeBase {
    public static void base(){

        LocalDateTime dt = LocalDateTime.now();
        LocalDate d = LocalDate.now();
        LocalTime t = LocalTime.now();

        System.out.println(d);
        System.out.println(t);
        System.out.println(dt);
    }
    public static void sameTime(){

        LocalDateTime dt = LocalDateTime.now();
        LocalDate d = dt.toLocalDate();
        LocalTime t = dt.toLocalTime();

        System.out.println(d);
        System.out.println(t);
        System.out.println(dt);

    }
    public static void main(String[] args) {
        // 自定义格式化
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));

        // 自定义格式解析
        LocalDateTime dt2 = LocalDateTime.parse("2019/11/30 15:16:17",dtf);
        System.out.println(dt2);
    }
}
