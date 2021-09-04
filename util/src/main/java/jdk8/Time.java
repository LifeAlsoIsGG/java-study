package jdk8;


import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description: JDK8新时间线程安全API：time
 * @Datetime: 2021/8/28 23:24:14
 */
public class Time{
    //参考：https://blog.csdn.net/weixin_38370441/article/details/112335489?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control
    // 所有类都是不可变类型而且线程安全
    // LocalDate：提供日期信息，不含时间信息。不附带任何与时区相关的信息。
    // LocalTime：提供时间信息，不含日期信息。不附带任何与时区相关的信息。
    // LocalDateTime：LocalDate和LocalTime的合体。同时表示了日期和时间，但不带有时区信息。
    // Instant：面向机器，包含的是由秒及纳秒所构成的数字。
    // 以Unix元年时间（传统设定为UTC时区1970年1月1日午夜时分）开始所经历的秒数进行计算。
    //
    // Duration：以秒和纳秒表示某两个时间之间/时间段的长短
    // Period：以年、月或者日的方式表示某两个时间之间/时间段的长短
    //
    // DateTimeFormatter：线程安全，时间格式，预先定义了许多实例，比如BASIC_ISO_DATE、ISO_LOCAL_DATE
    //
    // ZoneId：时区。ZoneRules类中定义了40个时区实例可以直接使用。
    // ZonedDateTime：参见下图，可以理解为有时区信息的LocalDateTime。
    //
    // MonthDay：这个类组合了月份和日，去掉 了年，这意味着你可以用它判断每年都会发生事件。
    // YearMonth：另一个组合类，用于表示信用卡到期日、FD到期日、期货期权到期日等。
    // 可以用这个类得到 当月共有多少天
    //
    // Clock时钟类：获取当时的时间戳，或当前时区下的日期时间信息。
    //         以前用到System.currentTimeMillis()和TimeZone.getDefault()的地方都可用Clock替换。

/*    类	说明
    Clock	使用时区提供对当前即时，日期和时间的访问的时钟
    Duration	计算两个“时间”的间隔
    Instant	在时间线上的瞬间点（常用）
    LocalDate	一个不可变的日期时间对象，表示日期，通常被视为年月日（常用）
    LocalTime	是一个不可变的日期时间对象，代表一个时间，通常被看作是小时 - 秒 （常用)
    LocalDateTime	是一个不可变的日期时间对象，代表日期时间，通常被视为年 - 月 - 日 - 时 - 分 - 秒（常用）
    MonthDay	是一个不变的日期时间对象，代表一年和一个月的组合
    OffsetDateTime	具有偏移量的日期时间的不可变表示
    OffsetTime	是一个不可变的日期时间对象，表示一个时间，通常被视为小时 - 秒 - 秒
    Period	用于计算两个“日期”的间隔
    Year	代表一年的不可变日期时间对象
    YearMonth	是一个不变的日期时间对象，表示一年和一个月的组合
    ZonedDateTime	是具有时区的日期时间的不可变表示*/

    /**
     * @description: Instant中是不带时区的即时时间点，且使用得的是UTC时间,面向机器,包含的是由秒及纳秒所构成的数字.一般用于和以前的Date转换
     **/
    public static void instantDemo(){
        Instant instant = Instant.now();
        //代替Date,精确到纳秒级，而Date精确到毫秒
        System.out.println("UTC时间：" + instant);
        System.out.println("北京时间：" + instant.plus(8, ChronoUnit.HOURS));
        //date和instant互相转换
        System.out.println(Instant.ofEpochMilli(new Date().getTime()));
        Date.from(instant);
        new Date().toInstant();

        //从字符串类型中创建Instant类型的时间
        System.out.println(Instant.parse("1995-10-23T10:12:35Z"));
        //计算
        //现在时间加5小时4分钟
        //Java.time 这个包是线程安全的，并且和其他大部分类一样，是不可变类。
        //Instant 也遵守这个规则，因此 plus() 方法会产生一个新的实例
        System.out.println(instant.plus(Duration.ofHours(5).plusMinutes(4)));
        //计算5天前的时间
        instant.minus(5, ChronoUnit.DAYS); // Option 1　方法1
        instant.minus(Duration.ofDays(5)); // Option 2  方法2
        //比较Instant
        //用compareTo方法比较,返回的是纳秒
        Instant instant1 = Instant.now();
        System.out.format("instant1.compareTo(instant)=%d.%n", instant1.compareTo(instant));
        // 使用isAfter()和isBefore()
        System.out.format("instant1.isAfter(instant)=%b, instant1.isBefore(instant)=%b.%n",
                instant1.isAfter(instant), instant1.isBefore(instant));
        //计算两个Instant之间的微秒
        long diffAsMinutes = ChronoUnit.MICROS.between(instant, instant1); // 方法2
        System.out.println("相差：" + diffAsMinutes);
    }

   /**
    * @description: LocalDate：提供日期信息，不含时间信息。不附带任何与时区相关的信息。
    **/
    public static void localDateDemo(){
        // 创建,表示不带时区的日期，比如 1-1-2000
        LocalDate today = LocalDate.now();
        LocalDate date;
        date = LocalDate.of(2014, 3, 18);
        date = LocalDate.parse("2014-03-18");
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(LocalDate.ofYearDay(2005, 86)); // 获得2005年的第86天 (27-Mar-2005)
        System.out.println(LocalDate.of(2013, Month.SEPTEMBER, 30));//2013年8月10日

        // 获取各个日期
        int year, month, day;
        year = date.getYear();
        date.getMonth();
        day = date.getDayOfMonth();
        DayOfWeek dow = date.getDayOfWeek();
        int len = date.lengthOfMonth();
        boolean leap = date.isLeapYear();
        year = date.get(ChronoField.YEAR);
        month = date.get(ChronoField.MONTH_OF_YEAR);
        day = date.get(ChronoField.DAY_OF_MONTH);


        // withAttribute方法会创建对象的一个副本，并按照需要修改它的属性
        date = LocalDate.of(2014, 3, 18);
        date.withYear(2011); // 2011-03-18
        date.withDayOfMonth(25); // 2011-03-25
        date.with(ChronoField.MONTH_OF_YEAR, 9); // 2011-09-25

        // 以相对方式修改LocalDate对象的属性
        date = LocalDate.of(2014, 3, 18);
        date.plusWeeks(1);
        date.minusYears(3);
        date.plus(6, ChronoUnit.MONTHS);

        // 使用预定义的TemporalAdjusters，将日期调整到下个周日、下个工作日，或者是本月的最后一天
        date = LocalDate.of(2014, 3, 18);
        date.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        date.with(TemporalAdjusters.lastDayOfMonth());

        // 打印输出几解析日期-时间对象
        date = LocalDate.of(2014, 3, 18);
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(LocalDate.parse("20140318", DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(LocalDate.parse("2014-03-18", DateTimeFormatter.ISO_LOCAL_DATE));

        // 判断日期先后
        LocalDate tomorrow = LocalDate.of(2014, 1, 15);
        System.out.format("tomorrow.compareTo(today)=%d.%n", tomorrow.compareTo(today));
        if(tomorrow.isAfter(today)){
            System.out.println("Tomorrow comes after today");
        }
        LocalDate yesterday = today.minus(1, ChronoUnit.DAYS);
        if(yesterday.isBefore(today)){
            System.out.println("Yesterday is day before today");
        }
        // Output:
        // Tomorrow comes after today
        // Yesterday is day before today

        // isLeapYear()判断该实例是否是一个闰年
        if(today.isLeapYear()){
            System.out.println("This year is Leap year");
        }else {
            System.out.println("2014 is not a Leap year");
        }

    }

    public static void localTimeDemo(){
        // 创建
        LocalTime time;
        time = LocalTime.of(13, 45, 20);
        time = LocalTime.parse("13:45:20");

        // 获取各个时间
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();

        //LocalTime 表示不带时区的时间，比如 04:44:50.12
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        System.out.println(LocalTime.of(22, 33));//10:33 PM
        System.out.println(LocalTime.ofSecondOfDay(4503)); // 返回一天中的第4503秒 (1:15:30 AM)
    }


    public static void localDateTimeDemo(){
        // LocalDateTime,它是LocalDate和LocalTime的组合体，表示的是不带时区的日期及时间,替换Calendar
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        LocalDateTime dt2 = LocalDateTime.of(date, time); // 根据LocalDate与LocalTime
        LocalDateTime dt3 = date.atTime(13, 45, 20);
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);

        // 转化为LocalDate与LocalTime
        LocalDate date1 = dt1.toLocalDate();
        LocalTime time1 = dt1.toLocalTime();

        // 将LocalDateTime转换为Instant
        LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
        ZoneOffset romeZone = ZoneOffset.from(dateTime);
        Instant instantFromDateTime = dateTime.toInstant(romeZone);

        // 得到LocalDateTime对象
        Instant instant = Instant.now();
        LocalDateTime timeFromInstant = LocalDateTime.ofInstant(instant, romeZone);

        //LocalDateTime -> TimeStamp
        Timestamp localDateTimeToTimeStamp = Timestamp.valueOf(LocalDateTime.now());
        System.out.println("LocalDateTime -> TimeStamp:  " + localDateTimeToTimeStamp);


        System.out.println("LocalDateTime:");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        //当前时间加上25小时３分钟
        LocalDateTime inTheFuture = localDateTime.plusHours(25).plusMinutes(3);
        // 同样也可以用在localTime和localDate中
        System.out.println(localDateTime.toLocalTime().plusHours(25).plusMinutes(3));
        System.out.println(localDateTime.toLocalDate().plusMonths(2));
        // 也可以使用实现TemportalAmount接口的Duration类和Period类
        System.out.println(localDateTime.toLocalTime().plus(Duration.ofHours(25).plusMinutes(3)));
        System.out.println(localDateTime.toLocalDate().plus(Period.ofMonths(2)));
    }

    public static void durationAndPeriod(){
        // 创建Duration,以秒和纳秒表示某两个时间之间/时间段的长短
        Duration duration;
        LocalTime localTime;
        LocalDate localDate;
        Instant instant;
        duration = Duration.between(localTime = LocalTime.now(), localTime.plusNanos(100));
        duration = Duration.between(localDate = LocalDate.now(), localDate.plusDays(10));
        duration = Duration.between(instant = Instant.now(), instant.plusNanos(1000));

        Duration threeMinutes;
        threeMinutes = Duration.ofMinutes(3);
        threeMinutes = Duration.of(3, ChronoUnit.MINUTES);

        // 创建Period,以年、月或者日的方式表示某两个时间之间/时间段的长短
        Period tenDays;
        tenDays = Period.between(LocalDate.of(2014, 3, 8), LocalDate.of(2014, 3, 18));
        tenDays = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);
    }

    public static void dateTimeFormatterDemo(){
        //线程安全，时间格式，预先定义了许多实例，比如BASIC_ISO_DATE、ISO_LOCAL_DATE
        LocalDate date = LocalDate.of(2014, 3, 18);
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE); //20140318
        String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE); //2014-03-18
        //适用于LocalDateTime   FormatStyle.SHORT  FormatStyle.LONG FormatStyle.MEDIUM      FormatStyle.FULL
        DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(date);//19-12-18
        DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(date);//2019年12月18日
        DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(date);//2019-12-18
        DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(date);//2019年12月18日 星期三

        LocalDate date1;
        LocalDate date2;
        date1 = LocalDate.parse("20140318", DateTimeFormatter.BASIC_ISO_DATE);
        date2 = LocalDate.parse("2014-03-18", DateTimeFormatter.ISO_LOCAL_DATE);

        // 按照某个模式创建DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        date1 = LocalDate.of(2014, 3, 18);
        String formattedDate = date1.format(formatter);
        date2 = LocalDate.parse(formattedDate, formatter);

        // 创建一个本地化的DateTimeFormatter
        DateTimeFormatter italianFormatter =
                DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
        date1 = LocalDate.of(2014, 3, 18);
        String formattedDat_2 = date.format(italianFormatter); // 18. marzo 2014
        date2 = LocalDate.parse(formattedDate, italianFormatter);
        // 日期格式“MMM d yyyy”和“MMM dd yyyy”有一些微妙的不同
        // 第一个格式可以解析“Jan 2 2014”和“Jan 14 2014”，而第二个在解析“Jan 2 2014”就会抛异常。
        // 第二个格式里要求日必须是两位的。
        // 如果想修正，你必须在日期只有个位数时在前面补零，就是说“Jan 2 2014”应该写成 “Jan 02 2014”。

        // 构造一个DateTimeFormatter
        DateTimeFormatter italianFormatter_2 = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(". ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendText(ChronoField.YEAR)
                .parseCaseInsensitive()
                .toFormatter(Locale.ITALIAN);

    }

    //时区
    public static void zoneIdDemo(){
        // 输出所有可见的时区ID，eg：Asia/Aden, America/Cuiaba, Etc/GMT+9等
        System.out.println(ZoneId.getAvailableZoneIds());
        //设置时区
        ZoneId romeZone = ZoneId.of("Europe/Rome");
        ZoneId zone_1 = ZoneId.of("Europe/Berlin");
        ZoneId zone_2 = ZoneId.of("Asia/Shanghai");
        System.out.println(zone_1.getRules());
        System.out.println(zone_2.getRules());
        // TimeZone的转换
        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        LocalDateTime dateTime;
        LocalDate date = LocalDate.of(2014, Month.MARCH, 18);
        ZonedDateTime zdt1 = date.atStartOfDay(romeZone);
        dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
        ZonedDateTime zdt2 = dateTime.atZone(romeZone);
        ZonedDateTime dateAndTimeInNewYork  = ZonedDateTime.of(dateTime , romeZone);
        Instant instant = Instant.now();
        ZonedDateTime zdt3 = instant.atZone(romeZone);

        // 将LocalDateTime转换为Instant
        dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
        // Instant instantFromDateTime = dateTime.toInstant(romeZone);
        // 得到LocalDateTime对象
        LocalDateTime timeFromInstant = LocalDateTime.ofInstant(instant, romeZone);

        // 比较通用的表达时区的方式是利用当前时区和UTC/格林尼治的固定偏差
        // 纽约时区落后于伦敦5小时
        ZoneOffset newYorkOffset = ZoneOffset.of("-05:00");
        dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
        OffsetDateTime dateTimeInNewYork = OffsetDateTime.of(dateTime, newYorkOffset);

    }

    public static void clockDemo(){
        // Clock使用时区来访问当前的instant, date和time。
        // Clock类可以替换 System.currentTimeMillis() 和 TimeZone.getDefault()。
        Clock clock = Clock.systemDefaultZone();//获取系统默认时区 (当前瞬时时间 )
        System.out.println( "系统时间日期：" + clock.instant());
        System.out.println( "时间毫秒：" + clock.millis());
        //获取系统时钟，并将其转换成使用UTC时区的日期和时间
        Clock clock_1 = Clock.systemUTC();
        System.out.println( "时间日期：" + clock_1.instant());
        System.out.println( "时间毫秒值：" + clock_1.millis());
    }

    public static void main(String[] args) {
       // instantDemo();
       // localDateDemo();
       // localDateTimeDemo();
        clockDemo();
       //  zoneIdDemo();
        System.out.println(OffsetDateTime.now());
        System.out.println(Instant.now().atZone(ZoneId.systemDefault()));
    }

}
