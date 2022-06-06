package org.muieer.string.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {

    public static void main(String[] args) {

        // 比较 matches 方法和 find 方法区别
        demo1();

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
