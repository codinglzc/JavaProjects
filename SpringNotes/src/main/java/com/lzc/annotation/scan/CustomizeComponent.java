package com.lzc.annotation.scan;

import java.lang.annotation.*;

/**
 * <p>
 *
 * </p>
 *
 * @author Liu Cong
 * @since 2018-08-08
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomizeComponent
{
    String value() default "";
}
