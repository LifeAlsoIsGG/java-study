import lombok.Data;

/**
 * @author Long Chen
 * @description
 * @date 2021-08-07 21:19
 */

@Data
public class MethodPrint {
	private String method;
	private Object flag;

	public MethodPrint(String method, Object flag) {
		this.method = method;
		this.flag = flag;
	}

	@Override
	public String toString() {
		return method + ':' + flag;
	}
}
