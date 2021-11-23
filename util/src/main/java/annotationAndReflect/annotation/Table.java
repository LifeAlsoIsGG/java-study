package annotationAndReflect.annotation;

import java.lang.annotation.*;

/**
 * @Package: annotationAndReflect.annotation
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/11/23 23:34:48
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Table {
    String value();
}
