import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Long Chen
 * @description
 * @date 2021-08-07 19:49
 */

public class StringUtilsDemo {
	public static void main(String[] args) {
		List<MethodPrint> methodPrints = methodPrints = new ArrayList<MethodPrint>();

		//判断字符串是否为空
		System.out.println("判断字符串是否为空");
		methodPrints.add(new MethodPrint("StringUtils.isEmpty(null)", StringUtils.isEmpty(null)));
		methodPrints.add(new MethodPrint("StringUtils.isEmpty(\"\")", StringUtils.isEmpty("")));
		methodPrints.add(new MethodPrint("StringUtils.isEmpty(\" \")", StringUtils.isEmpty(" ")));
		methodPrints.add(new MethodPrint("StringUtils.isEmpty(\"bob\")", StringUtils.isEmpty("bob")));
		methodPrints.add(new MethodPrint("StringUtils.isEmpty(\"bob \")", StringUtils.isEmpty("bob ")));
		methodPrints.add(new MethodPrint("StringUtils.isNotEmpty(\"bob \")", StringUtils.isNotEmpty("bob ")));
		methodPrints.forEach(System.out::println);
		methodPrints.clear();

		System.out.println();
		System.out.println("判断某字符串是否为空或长度为0或由空白符(whitespace) 构成");
		methodPrints.add(new MethodPrint("StringUtils.isBlank(null)", StringUtils.isBlank(null)));
		methodPrints.add(new MethodPrint("StringUtils.isBlank(\"\")", StringUtils.isBlank("")));
		methodPrints.add(new MethodPrint("StringUtils.isBlank(\" \")", StringUtils.isBlank(" ")));
		methodPrints.add(new MethodPrint("StringUtils.isBlank(\"bob\")", StringUtils.isBlank("bob")));
		methodPrints.add(new MethodPrint("StringUtils.isNotBlank(\"bob\")", StringUtils.isNotBlank("bob")));

		methodPrints.forEach(System.out::println);
		methodPrints.clear();

		//去掉字符串两端的控制符(control characters, char <= 32)
		methodPrints.add(new MethodPrint("StringUtils.trim(null)", StringUtils.trim(null)));
		methodPrints.add(new MethodPrint("StringUtils.trim(\"\")", StringUtils.trim("")));
		methodPrints.add(new MethodPrint("StringUtils.trim(\" d   d dd     \")", StringUtils.trim(" d   d dd     ")));
		methodPrints.add(new MethodPrint("StringUtils.trim(\"     dd       \")", StringUtils.trim("     dd       ")));


		methodPrints.forEach(System.out::println);
		methodPrints.clear();

	}

}
