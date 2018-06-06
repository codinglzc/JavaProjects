package annotation.ASimpleDB;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 为修饰JavaBean域准备的注解
 * @Author: lzc
 * @Date: Created at 2018-06-04
 */
@Target(ElementType.FIELD) // 只作用于域
@Retention(RetentionPolicy.RUNTIME)
public @interface Constrains
{
    boolean primaryKey() default false; // 表字段是否为主键，默认为否

    boolean allowNull() default true;   // 表字段是否允许为null，默认为是

    boolean unique() default false;     // 表字段是否为独一无二的，默认为否
}
