package 面试题代码;

import static net.mindview.util.Print.print;
import org.junit.Test;

import java.util.Stack;

/**
 * @version 1.0
 * @Description: 字符串倒转
 * @author: hxw
 * @date: 2019/3/7 16:59
 */
public class StringReverse {

    //方式一：直接使用StringBuilder的reverse方法
    public static String reverse11(String s){
        return new StringBuilder(s).reverse().toString();
    }

    //方式二： 使用递归
    public static String reverse12(String s){
        int length = s.length();
        if (length <= 1){
            return s;
        }
        String left = s.substring(0, length / 2); //将字符串分为左半部分和右半部分，依次递归分解
        String right = s.substring(length / 2, length);
        return reverse12(right) + reverse12(left); //这里是重点，将右边的字符加上左边的字符进行拼接
    }

    //方式三： 通过 charAt(int index)返回char值进行字符串拼接
    public static String reverse13(String s){
        int length = s.length();
        String reverse = "";
        for (int i = 0; i < length; i++)
            reverse = s.charAt(i) + reverse; //重点是这里倒序拼接
        return reverse;
    }


    //方法四： 把字符串转换成字符数组首尾对调位置
    public static String reverse14(String s){
        char[] s1 = s.toCharArray(); //字符串转化成char数组
        int n = s1.length - 1;
        int halfLength = n / 2;
        for (int i = 0; i <= halfLength; i++) {
            char temp = s1[i];
            s1[i] = s1[n - i]; //首位字符对调
            s1[n - i] = temp;
        }
        return new String(s1);
    }

    //方法五：巧妙利用栈的先进后出的特性
    public static String reverse15(String s){
        char[] str = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length; i++)
            stack.push(str[i]); //将字符串的每一个字符进行遍历存入栈中
        String reversed = "";
        for (int i = 0; i < str.length; i++) //弹栈，将里面的元素拿出，最先出来的就是之前字符串中某位的字符，依次拼接
            reversed += stack.pop();
        return reversed;
    }


    @Test
    public void test(){
        print(reverse11("abcdefg"));
        print(reverse12("abcdefg"));
        print(reverse13("abcdefg"));
        print(reverse14("abcdefg"));
        print(reverse15("abcdefg"));
    }
}
