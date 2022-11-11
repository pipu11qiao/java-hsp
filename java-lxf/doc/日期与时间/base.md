Epoch Time 是计算1970年1月1日 道现在经历的秒数。
epoch time 也称为时间戳 以秒为单位的整数，以毫秒为单位的整数 以秒为单位的浮点数

java中 时间戳通常是用long表示的毫秒数

标注API

两套处理日期与时间的API

* java.util这个包里面包括 Date Calendar 和 TimeZone
* java.time 这个包里面，包括 LocalDateTime ZonedDateTime ZoneId

Date对象有几个严重的问题： 不能转换时区，出了toGMTString()可以按GMT+0:00输出外 Date总是以当前计算机系统的默认时区为基础机型输出。
很难对日期对日期和时间进行加减，计算两个日期相差多少天

Calendar

Calendar可以用来获取年、月、日...，和Date比，主要多了一个可以做简单的日期和时间运算的功能

get(int field) 返回的月份仍然要加1， 1-7表示周日-周六

Calendar只有一种方式获取，Calendar.getInstance. 如果想获取特定时间需要先清楚，在设置

```java
import java.util.Calendar;

class Demo {
    public static void main(String[] args) {
        Calendar c = new Calendar();
        
        c.clear();
        c.set(Calendar.YEAR,2019);
    }
}


```

getTime()方法可以讲一个Calendar对象转换成Date对象，然后可以使用SimpleDateFormat


TimeZone
提供了时区转换功能
```java
import java.util.TimeZone;

public class BaseTimeZone {
    public static void main(String[] args) {
        TimeZone tzDefault = TimeZone.getDefault();
        TimeZone tzGMT9 = TimeZone.getTimeZone("GMT+09:00");
        TimeZone tzNY = TimeZone.getTimeZone("America/New_York");

        System.out.println(tzDefault.getID());
        System.out.println(tzGMT9.getID());
        System.out.println(tzNY.getID());

    }
}

```

时区的唯一标识是以字符串表示的ID, TimeZone.getAvailableIDs();




