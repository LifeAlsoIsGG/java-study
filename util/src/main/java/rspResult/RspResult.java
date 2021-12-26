package rspResult;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @Package: com.longchen.springcloudstudy.entity
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/11/26 23:18:23
 */
@Data
@Builder(toBuilder = true)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class RspResult<T> implements Serializable {

    private static final long serialVersionUID = -8373949666192372417L;

    private Integer code;

    private String message;

    private T data;

    private IPage<T> page;

    private String datetime;

    private static String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public static <T> RspResult<T> build(Integer code, String message, T data, IPage<T> page) {
        return new RspResult<T>().setCode(code).setMessage(message).setData(data).setPage(page).setDatetime(now());
    }

    public static <T> RspResult<T> build(RspResultEnums rspResultEnum, T data, IPage<T> page) {
        return build(rspResultEnum.getCode(), rspResultEnum.getMessage(), data, page);
    }

    public static <T> RspResult<T> success(T data, IPage<T> page) {
        return build(RspResultEnums.SUCCESS, data, page);
    }

    public static <T> RspResult<T> success(T data) {
        return success(data, null);
    }

    public static <T> RspResult<T> success() {
        return success(null, null);
    }


    public static <T> RspResult<T> fail() {
        return build(RspResultEnums.FAIL, null, null);
    }


    //public RspResult<T> setCode(Integer code) {
    //    this.code = code;
    //    return this;
    //}
    //
    //public RspResult<T> setMessage(String message) {
    //    this.message = message;
    //    return this;
    //}
    //
    //public RspResult<T> setData(T data) {
    //    this.data = data;
    //    return this;
    //}
    //
    //public RspResult<T> setPage(IPage<T> page) {
    //    this.page = page;
    //    return this;
    //}
    //
    //public RspResult<T> setDatetime(String datetime) {
    //    this.datetime = datetime;
    //    return this;
    //}
    //
    //public Integer getCode() {
    //    return code;
    //}
    //
    //public String getMessage() {
    //    return message;
    //}
    //
    //public T getData() {
    //    return data;
    //}
    //
    //public IPage<T> getPage() {
    //    return page;
    //}
    //
    //public String getDatetime() {
    //    return datetime;
    //}

}


