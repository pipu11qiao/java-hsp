从java8开始，java.time包提供了新的日期和时间API，主要涉及的类型有：

* 本地日期时间： LocalDateTime, LocalDate, LocalTime
* 带时区的日期和时间： ZonedDateTime
* 时刻： Instant
* 时区： ZoneId,ZoneOffset
* 时间间隔： Duration
  以及一套新的用于取代SimpleDateFormat的格式化类型DateTimeFormatter

* Month范围用1-12表示1月到12月
* Week的范围用1-7表示周一到周日

## LocalDateTime

表示本地的日期和时间

```java
public class LocalDateTimeBase {
    public static void main(String[] args) {
        LocalDate d = LocalDate.now();
        LocalTime t = LocalTime.now();

        LocalDateTime dt = LocalDateTime.now();

        System.out.println(d);
        System.out.println(t);
        System.out.println(dt); //严格按照ISO 8601格式打印
    }
}
    为了获取一致的毫秒数 dt.toLocalDate()dt.toLocalTime

```

ISO 8601的格式规范 日期和时间分隔符T

* 日期： yyyy-MM-dd
* 时间 HH:mm:ss
* 带毫秒的时间 HH:mm:ss:SSS
* 日期和时间 yyyy-MM-dd'T'HH:mm:ss
* 带毫秒的日期和时间 yyyy-MM-dd'T'HH:mm:ss:SSS

## DateTimeFormatter

如果要格式化输出，或者要把一个ISO 8601格式的字符串解析成LocalDateTime,可以使用DateTimeFormatter:

### 日期调整

```java

LocalDateTime dt1=dt.plusDays(5).minusHours(3);
LocalDateTime dt2=dt.minusMonths(1);
```
加减很方便

调整也是 withYear withMonth withDayOfMonth withHour withMinute withSecond

实际上新的Api中还有很多方便的api来获取想要的时间

atStartOfDay()
lastDayOfMonth()
firstDayOfNextMonth()
// 本月第一个周一
firstInMonth(DayofWeek.MONDAy)


日期比较也很方便

isBefore()
isAfter()


### Duration和Period

Duration 表示两个时刻之间的时间间隔，period表示两个日期之间额天数


# ZonedDateTime

ZonedDateTime 可以简单的理解成LocalDateTime 加 ZoneId,

ZonedDateTime.now()
ZonedDateTime.now(ZonId.of("America/New_York"))


ldt.atZone(ZonId.systemDefault());
ldt.atZone(ZoneId.of("America/New_York"))

### 时区转换

zbj.withZoneSameInstant(ZoneId.of("America/New_York"));


转换本地时间

zdt.toLocalDateTime();

# DateTimeFormatter

和SimpleDateFormat不同的事，DateTimeFormatter 不但是不变对象，还是线程安全的。

var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
formatter.format(zdt);


# Instant

Instant now = Instant.now()
now.getEpochSecond() // 秒
now.toEpochMill() //毫秒




