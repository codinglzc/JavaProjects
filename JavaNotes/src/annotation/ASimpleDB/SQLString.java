package annotation.ASimpleDB;

import java.lang.annotation.*;

/**
 * @Description:
 * @Author: lzc
 * @Data: created at 2018-06-04
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLString
{
    int value() default 0;

    String name() default "";

    Constrains constraints() default @Constrains;
}
