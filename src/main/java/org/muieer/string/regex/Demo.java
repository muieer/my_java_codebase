package org.muieer.string.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {

    public static void main(String[] args) {

        // 比较 matches 方法和 find 方法区别
//        demo1();

        // 正则转义
        replaceDemo();

    }

    public static void replaceDemo() {

        // 正斜杠转义
        String str = "\\"; // 字符串转义后为反斜杠 \
        System.out.println(str.replaceAll("\\\\", "q"));
        // 使用 Pattern.quote 实现正则表达式的输入转义
        System.out.println(str.replaceAll(Pattern.quote("\\"), "q"));

        str = "\\n\n\\"; //字符串转义后为 反斜杠，n，换行，反斜杠
        // 正则表达式现字符串转义为 反斜杠，反斜杠，n，再正则转义为 \n，最后正则转义为换行符
        System.out.println(str.replaceAll("\\\n", "q"));
        System.out.println(str.replaceAll(Pattern.quote("\n"), "q"));

    }

    public static void demo1() {

        Pattern p1 = Pattern.compile("((?i)cat)");
        Matcher matcher1 = p1.matcher("Cat cat");

        while (matcher1.find()) {
            System.out.println("matcher1 result is " + matcher1.group());
        }

        Pattern p2 = Pattern.compile("((?i)cat) \\1");
        Matcher matcher2 = p2.matcher("Cat Cat");
        if (matcher2.matches()) System.out.println("matcher2 result is " + matcher2.group());

        Pattern p3 = Pattern.compile("((?i)cat)");
        Matcher matcher3 = p3.matcher("Cat cat");
        //无法比配，因为 matches 方法将整个输入串用来匹配，find 方法可以用输入串子串做匹配
        if (matcher3.matches()) System.out.println("matcher3 result is " + matcher2.group());

    }
}
