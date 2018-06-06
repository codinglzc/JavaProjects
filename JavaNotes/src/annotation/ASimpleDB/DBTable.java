package annotation.ASimpleDB;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 这个注解用于生成一个数据库表
 * @Author: lzc
 * @Date: Created at 2018-06-04
 */
@Target(ElementType.TYPE) // 只作用于类、接口、枚举、注解
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable
{
    public String name() default ""; // 数据库的表名
}
