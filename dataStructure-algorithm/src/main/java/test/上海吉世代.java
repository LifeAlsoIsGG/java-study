package test;

import org.apache.commons.lang3.StringUtils;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/5/29 19:59:06
 */
public class 上海吉世代 {

    /*
    * 题目：写一个字符串转换函数
    输入：以驼峰命名法为格式的字符串，
    输出：相应的以下划线命名法为格式的字符串
    要求：
    1. 只遍历输入字符串一遍
    2. 注意合理处理连续的大写字母如 HTTP
    3. 请提供单元测试，不局限于下面的例子
    4. 语言不限


    例子 1
    输入：myFirstName
    输出：my_first_name


    例子 2
    输入：OnlineUsers
    输出：online_users


    例子 3
    输入：Address
    输出：address


    例子 4
    输入：validHTTPRequest
    输出：valid_http_request
    * */
    public static String print(String str){
        //如果字符串为空为null或只有空白字符直接返回，如果不是全部英文也返回null
        if (StringUtils.isBlank(str) || !str.matches("[a-zA-Z]+")){
            return null;
        }


        StringBuilder stringBuffer = new StringBuilder();

        //转换为字符数组
        char[] chars = str.toCharArray();

        //处理第一个
        stringBuffer.append(Character.toLowerCase(chars[0]));

        //遍历
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];

            //判断当前是大写字母时
            if(Character.isUpperCase(c)){
                //判断如果后面的字母是小写才加下划线，否则不加
                if(i < chars.length - 1 && (Character.isLowerCase(chars[i - 1]) || Character.isLowerCase(chars[i + 1]))){
                    stringBuffer.append("_");
                }
                c = Character.toLowerCase(chars[i]);
            }
            stringBuffer.append(c);
        }

        return new String(stringBuffer);
    }

    public static void main(String[] args) {
        //输入错误用例
        System.out.println(print(null));
        System.out.println(print("s1112"));
        System.out.println(print("    "));


        //正确用例
        System.out.println(print("myFirstName"));
        System.out.println(print("OnlineUsers"));
        System.out.println(print("Address"));
        System.out.println(print("address"));
        System.out.println(print("validHTTPRequest"));
        System.out.println(print("HTTPValidHTTPSRequest"));
        System.out.println(print("HTTP"));

        /*
        * null
        * null
        * null
        * my_first_name
        * online_users
        * address
        * address
        * valid_http_request
        * http_valid_https_request
        * http
        * */
    }
}
