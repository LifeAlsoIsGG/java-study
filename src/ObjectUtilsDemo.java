import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.ObjectUtils;

/**
 * @author Long Chen
 * @description ObjectUtils工具使用
 * @date 2021-08-06 11:54
 */

public class ObjectUtilsDemo {
	public static void main(String[] args) {
		List<MethodPrint> methodPrints;

		//判断null|空字符串|空数组|空集合|空map
		System.out.println("判断null|空字符串|空数组|空集合|空map");
		methodPrints = new ArrayList<MethodPrint>();
		methodPrints.add(new MethodPrint("isEmpty(null)", ObjectUtils.isEmpty(null)));
		methodPrints.add(new MethodPrint("isEmpty(字符串)", ObjectUtils.isEmpty("")));
		methodPrints.add(new MethodPrint("isEmpty(new int[]{})", ObjectUtils.isEmpty(new int[]{})));
		methodPrints.add(new MethodPrint("isEmpty(new ArrayList<>())", ObjectUtils.isEmpty(new ArrayList<>())));
		methodPrints.add(new MethodPrint("isEmpty(new HashMap<>())", ObjectUtils.isEmpty(new HashMap<>())));
		methodPrints.forEach(System.out::println);
		methodPrints.clear();


		//检查所有元素是否为空或有一个元素不为空
		System.out.println();
		System.out.println("检查所有元素是否为空或有一个元素不为空");
		methodPrints.add(new MethodPrint("allNotNull(null, 1)", ObjectUtils.allNotNull(null, 1)));
		methodPrints.add(new MethodPrint("allNotNull(1, 2)", ObjectUtils.allNotNull(1, 2)));
		methodPrints.add(new MethodPrint("anyNotNull(null, null)", ObjectUtils.anyNotNull(null, null)));
		methodPrints.add(new MethodPrint("anyNotNull(null, 2)", ObjectUtils.anyNotNull(null, 2)));
		methodPrints.forEach(System.out::println);
		methodPrints.clear();

		//拷贝对象
		System.out.println();
		methodPrints
			.add(new MethodPrint("defaultIfNull(null, true)", ObjectUtils.defaultIfNull(null, true)));
		//判断是否不相等，避免null调用equals
		methodPrints
			.add(new MethodPrint("ObjectUtils.notEqual(null, 10)", ObjectUtils.notEqual(null, null)));
		methodPrints.forEach(System.out::println);
		methodPrints.clear();


		/**
		 * 如果一个类没有重写toString方法本身，将会通过Object类的toString方法获取对象的字符串对象，
		 */
		String s1 = ObjectUtils.identityToString(null);
		String s2 = ObjectUtils.identityToString("");
		String s3 = ObjectUtils.identityToString(Boolean.TRUE);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}
}
