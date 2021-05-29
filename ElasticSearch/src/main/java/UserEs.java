import lombok.Builder;
import lombok.Data;

/**
 * @Package: sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/5/8 1:01:05
 */
@Data
@Builder(toBuilder = true)
public class UserEs {
    private String name;
    private Integer age;
    private String gender;
}
