package java8.time;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @description: 使用时区的日期时间API
 * 如果我们需要考虑到时区，就可以使用时区的日期时间API：
 * @author: Liu Cong
 * @create: Created at 2018-06-09
 */
public class Zoned
{
    public static void main(String[] args)
    {
        // 获取当前时间日期
        ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("date1: " + date1);

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当前时区：" + currentZone);
    }
}
