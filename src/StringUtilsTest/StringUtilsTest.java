package StringUtilsTest;

import org.apache.commons.lang3.StringUtils;

/**
 * @Project: Java-Study
 * @Package: StringUtilTest
 * @ClassName: StringUtilTest
 * @Author: v_geekrchen
 * @Description:
 * @Datetime: 2021/2/17  16:20:49
 */
public class StringUtilsTest {
    private static final String str = "fuck me";

    public static void main(String[] args) {
        System.out.println(StringUtils.startsWith(str, "fuck"));

    }
}
