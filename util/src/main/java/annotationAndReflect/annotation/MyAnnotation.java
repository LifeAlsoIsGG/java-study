package annotationAndReflect.annotation;

import annotationAndReflect.Main;
import java.lang.annotation.*;

/**
 * @Package: annotationAndrReflect.annotation
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/11/23 0:27:02
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
@Inherited
public @interface MyAnnotation {

    //value为默认参数使用时可以不指定参数名
    String value();

    Class<? extends Main> classType() default Main.class;

    ElementType type() default ElementType.METHOD;

    int[] array() default {};
}
