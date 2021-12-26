package rspResult;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * @Package: com.longchen.springcloudstudy.entity.ResponseResult
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/11/26 23:24:36
 */
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum RspResultEnums implements CustomizeResult {

    /* 成功 */
    SUCCESS(20000, "success"),

    /* 默认失败 */
    FAIL(-1, "fail"),

    /* 参数错误：1000～1999 */
    PARAM_NOT_VALID(1001, "参数无效"),
    PARAM_IS_BLANK(1002, "参数为空"),
    PARAM_TYPE_ERROR(1003, "参数类型错误"),
    PARAM_NOT_COMPLETE(1004, "参数缺失"),

    /* 系统相关 */
    LOGIN_SUCCESS(SUCCESS.getCode(), "登陆成功"),
    LOGOUT_SUCCESS(SUCCESS.getCode(), "退出登陆成功"),
    SELECT_MENUS_SUCCESS(SUCCESS.getCode(), "获取菜单成功"),
    GET_LOGGEDUSER_SUCCESS(SUCCESS.getCode(), "获取当前登录用户信息成功"),
    SELECT_USER_SUCCESS(SUCCESS.getCode(), "查询用户成功"),
    BATCH_BAN_USER_SUCCESS(SUCCESS.getCode(), "批量禁用用户成功"),
    BATCH_RELEASE_USER_SUCCESS(SUCCESS.getCode(), "批量解禁用户成功"),
    REGISTER_SUCCESS(SUCCESS.getCode(), "注册成功"),


    WRONG_USERNAME_PASSWORD(20001,"用户名或密码错误"),
    USER_DISABLED(20002,"此用户已禁用"),
    USER_PERMISSION_DENIED(20003, "权限不足,请联系管理员"),
    USER_NOT_LOGIN(20004, "用户未登录或登录已失效，请重新登录"),
    CANT_GET_LOGGEDUSER(20005, "无法获取到当前登录用户信息"),
    WRONG_CODE(20006, "未输入验证码或验证码错误"),
    USER_NOT_EXIST(20007, "此账号不存在"),
    ENUM_NOT_FOUND(20008, "未找到该枚举类型"),
    USERNAME_OR_STAFFID_IS_NULL(20009, "staffName或staffId为空"),

    /* 资源库相关 */
    SELECT_RESOURCE__SUCCESS(SUCCESS.getCode(), "获取资源库成功"),
    SELECT_RESOURCE_DETAIL_SUCCESS(SUCCESS.getCode(), "获取资源库下的资源成功"),
    EXPORT_RESOURCE_TEMPLATE_SUCCESS(SUCCESS.getCode(), "下载资源Excel模板成功"),
    CREATE_RESOURCE_SUCCESS(SUCCESS.getCode(), "创建资源库成功"),
    IMPORT_RESOURCE_SUCCESS(SUCCESS.getCode(), "导入资源成功"),
    RESOURCE_NAME_AVAILABLE(SUCCESS.getCode(), "此资源库名可用"),
    SELECT_RESOURCE_SUCCESS(SUCCESS.getCode(), "查询资源库成功"),
    FORK_RESOURCE_SUCCESS(SUCCESS.getCode(), "fork资源库成功"),
    COPY_RESOURCE_SUCCESS(SUCCESS.getCode(), "复制资源库成功"),
    UPDATE_RESOURCE_SUCCESS(SUCCESS.getCode(), "修改资源库成功"),
    DELTED_RESOURCE_SUCCESS(SUCCESS.getCode(), "删除资源库成功"),

    RESOURCE_NAME_UNAVAILABLE(20101, "此资源库名已存在"),
    RESOURCE_NOT_FOUND(20102, "资源库未找到"),
    USER_RESOURCE_NOT_HAVE(20103, "该用户还没有资源库"),
    RESOURCE_IS_PRIVATE(20104, "无法fork私有资源库"),
    CANT_FORK_MINE_RESOURCE(20105, "无法fork自己的资源库"),
    CANT_SELECT_PRIVATE_RESOURCE(20106, "只能查询公共资源库下的资源"),
    ONLY_COPY_MINE_RESOURCE(20107, "只能复制自己的资源库"),
    FORK_RESOURCE_FAIL(20108, "fork公共资源库失败"),
    SELECT_RESOURCE_NOT_MATCH(20108, "选中的资源库与数据库中的资源库不完全匹配"),
    ONLY_IMPORT_NORMAL_RESOURCE(20109, "只能导入到普通资源库"),

    /* 请求识曲相关相关 */
    SELECT_RECOGNITION_SUCCESS(SUCCESS.getCode(), "查询识曲任务成功"),
    SELECT_RECOGNITION_LOG_SUCCESS(SUCCESS.getCode(), "查询识曲任务日志成功"),
    CREATE_RECOGNITION_SUCCESS(SUCCESS.getCode(), "创建识曲任务成功"),
    RECOGNITION_NAME_AVAILABLE(SUCCESS.getCode(), "此识曲任务名可用"),
    RECOGNITION_SUCCESS(SUCCESS.getCode(), "此识曲任务识别完成"),
    EXPORT_RECOGNITION_RESULT_SUCCESS(SUCCESS.getCode(), "导出识曲任务识别结果成功"),
    PAUSE_RECOGNITION_SUCCESS(SUCCESS.getCode(), "暂停识曲任务成功"),
    END_RECOGNITION_SUCCESS(SUCCESS.getCode(), "结束识曲任务成功"),
    SELECT_PROCESSING_RECOGNITION_SUCCESS(SUCCESS.getCode(), "查询正在进行中的任务进度成功"),
    INCREMENT_RECOGNITION_SUCCESS(SUCCESS.getCode(), "增量识曲任务成功"),
    SELECT_INCREMENT_LOG_SUCCESS(SUCCESS.getCode(), "查询增量记录成功"),
    START_OR_CONTINUE_RECOGNITION_SUCCESS(SUCCESS.getCode(), "开始/继续识曲任务成功"),
    UPDATE_RECOGNITION_SUCCESS(SUCCESS.getCode(), "更新识曲任务成功"),
    PUSH_TASK_BY_EXCEL_SUCCESS(SUCCESS.getCode(), "通过excel推送任务到识曲任务成功"),
    SELECT_RECOGNITION_PROCESSING_AND_RESULT_SUCCESS(SUCCESS.getCode(), "查询识曲任务状态进度和识曲日志成功"),

    RECOGNITION_NAME_UNAVAILABLE(20201, "此识曲任务名已存在"),
    RECOGNITION_NOT_FOUND(20202, "识曲任务未找到"),
    RECOGNITION_HAVE_FINISHED(20203, "此识曲任务已完成"),
    RECOGNITION_PAUSE_OR_END(20204, "此识曲任务已暂停或已结束"),
    RECOGNITION_PROCESSING_OR_FINISH(20205, "此识曲任务正在进行中或已完成"),
    RECOGNITION_CANT_PAUSE(20206, "只能暂停正在进行中的识曲任务"),
    RECOGNITION_FINISH_OR_END(20206, "该识曲任务已完成或已结束"),
    RECOGNITION_CANT_OPERATE(20207, "只能操作自己的识曲任务"),
    RECOGNITION_NOT_EXIST(20208, "识曲任务不存在"),
    SELECT_RECOGNITION_NOT_MATCH(20209, "选中的识曲任务与数据库中的识曲任务不完全匹配"),
    RESOURCE_NOT_MINE(20210, "只能选择自己的资源库创建任务"),
    RECOGNITION_NOT_HAVE(20211, "您还没有识曲任务"),
    RESOURCE_LESS_THAN_RECOGNITION(20212, "增量失败，资源库资源数量小于识曲任务日志数量"),
    NOT_NEW_RESOURCE_DETAIL(20213, "未检测到新的资源"),
    RECOGNITION_ALREADY_PAUSE(20214, "识曲任务已暂停"),
    ONLY_RESOURCE_RECOGNITION_NEED_RESOURCE(20215, "只有类型为资源库识曲任务才要选择资源库"),
    QPS_NOT_IN_OPTIONS(20216, "选择的QPS不在可选范围内"),
    ABT_NOT_IN_OPTIONS(20217, "选择的返回结果类型不在可选范围内"),
    ONLY_OPEN_RECOGNITON_CAN_PUSH(20218, "只有开放型识曲任务能外部推送任务"),




/*    USER_NOT_LOGIN(20010, "用户未登录"),
    USER_ACCOUNT_EXPIRED(20002, "账号已过期"),
    USER_CREDENTIALS_ERROR(20003, "密码错误"),
    USER_CREDENTIALS_EXPIRED(20004, "密码过期"),
    USER_ACCOUNT_DISABLE(20005, "账号不可用"),
    USER_ACCOUNT_LOCKED(20006, "账号被锁定"),
    USER_ACCOUNT_NOT_EXIST(20007, "账号不存在"),
    USER_ACCOUNT_ALREADY_EXIST(20008, "账号已存在"),
    USER_ACCOUNT_USE_BY_OTHERS(20009, "账号下线"),*/

    /*部门错误*/
    DEPARTMENT_NOT_EXIST(3007, "部门不存在"),
    DEPARTMENT_ALREADY_EXIST(3008, "部门已存在"),

    /* 业务错误 */
    NO_PERMISSION(3001, "没有权限"),

    /*运行时异常*/
    ARITHMETIC_EXCEPTION(9001,"算数异常");


    private Integer code;
    private String message;

    RspResultEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
