import java.util.Arrays;

/**
 * @author Long Chen
 * @description
 * @date 2021-08-20 16:05
 */

public class Demo1 {

	public static void main(String[] args) {
		String str = "`aaa``bbb``ccc`";
		str = str.substring(1, str.length() - 1);
		Arrays.asList(str.split("``")).forEach(System.out::println);
	}
}
