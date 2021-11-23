package annotationAndReflect.entity;

import annotationAndReflect.annotation.Table;
import annotationAndReflect.annotation.TableField;

/**
 * @Package: annotationAndReflect.entity
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/11/23 23:37:53
 */
@Table("student")
public class Student {

    @TableField(value = "id", type = "int")
    private Integer id;

}
