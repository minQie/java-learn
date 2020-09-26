package priv.wmc.study.senior.reflect.enums;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Wang Mincong
 * @date 2020-08-08 17:43:40
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE})
public @interface Hello {

    String value();
}
