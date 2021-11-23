package annotationAndReflect.annotation;

import java.lang.annotation.*;

/**
 * @Package: annotationAndReflect.annotation
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/11/23 23:35:42
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TableField {

    String value();

    String type();

}
