package Entity;

import lombok.Builder;
import lombok.Data;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/5/8 1:01:05
 */
@Data
@Builder(toBuilder = true)
public class User {
    private String name;
    private Integer age;
    private String gender;
}
