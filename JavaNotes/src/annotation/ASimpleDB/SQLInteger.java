package annotation.ASimpleDB;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 
 * @Author: lzc
 * @Data: created at 2018-06-04
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLInteger
{
    String name() default "";

    Constrains constraints() default @Constrains;
}
