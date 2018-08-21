package strings;

import org.junit.Test;

/**
 * @version 1.0
 * @Description: 正则表达式反向引用
 * @author: hxw
 * @date: 2018/8/21 23:08
 */
public class BackReference {

    // \1：表示的是引用第一次匹配到的()括起来的部分。
    // \2：表示的是引用第二次匹配到的()括起来的部分。
    @Test
    public void test1(){
        String regex = "^([ab])\\1$";
        String str = "ab";
        String str1 = "aa";
        String str2 = "bb";
        System.out.println(str.matches(regex)); //false
        System.out.println(str1.matches(regex)); //true
        System.out.println(str2.matches(regex)); //true
        /*
            首先这里是匹配两位，[ab]一位,\1又引用[ab]一位 这里的\1会去引用（[ab]）匹配到的内容，因为([ab])是第一次匹配到的内容。
              如：str = "aa"时，([ab])匹配到a，所以\1引用([ab])的值也为a，所以str="aa"能匹配
              str = "bb"时，([ab])匹配到b，因为\1引用([ab])的值是b,所以str="bb"也能匹配
              而当str = "ab"时 ([ab])匹配到a,因为\1引用([ab])的值是a，所以只能是aa才能匹配，而此时str为ab，所以无法匹配。
        */
    }

    @Test
    public void test2(){
        String regex1 = "^(\\d)\\1[0-9](\\d)\\1{2}";
        System.out.println("335933".matches(regex1)); //true
        System.out.println("336444".matches(regex1)); //false
        // 注意在后面第二个(\\d)\\1{2}中的\\1，这里的\\1并不会去匹配他前面的(\\d)，而是匹配第一个(\\d)
    }
}
