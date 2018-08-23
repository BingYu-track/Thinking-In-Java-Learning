package strings;

import innerclasses.X;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @Description: 正则表达式特殊构造
 * @author: hxw
 * @date: 2018/8/22 8:31
 */
public class SpecialConstructor {

    @Test
    public void test1(){

        /*
         (?:X) X，作为非捕获组
         与捕获组 () 的意思一样也是将其作为一组进行处理，与捕获组的区别在于不捕获匹配的文本，仅仅作为分组,而不是捕获组。
         比如：要匹配 123123 这个，就可以写为 (123)\\1 使用反向引用，这时只能用捕获组，在匹配123 后会保留在内存中，便于反向引用；
         (?:123) 在匹配完后则不会保留反向引用，区别仅在于此。不保留反向引用可以节省内存，提高效率。
         (123)\\1等效(?:123)123，代码示例：
         */
        Pattern p = Pattern.compile("(123)\\1");
        Matcher m = p.matcher("ad123dfe123123grr");
        System.out.println("模式(123)\\1");
        while(m.find()){
            System.out.println(m.group());
        }

        /**
         * outputs
         * 模式(?:123)123
         * 123123
         */
        p = Pattern.compile("(?:123)123");
        m = p.matcher("ad123dfe123123grr");
        System.out.println("模式(?:123)123");
        while(m.find()){
            System.out.println(m.group()); //获取的0捕获组
        }
        System.out.println(m.groupCount()); //0 发现没有捕获组
        /*通过实验，（?：X）的作用是取消分组，不能使用group函数捕获该组，当然也无法使用反向引用但grup(0)时仍然包含该组的内容。
          非捕获组，其实这个对结果不影响的，只是说你这个括号不是分组，只是为了把一段规则包含起来。因为保存分组需要时间和内存。使用非捕获组可以提升性能。
        */
    }


    //(?idmsux-idmsux)  Nothing，但是将匹配标志 i d m s u x on - off
    //用于标志匹配，比如：表达式 (?i)abc(?-i)def 这时，(?i) 打开不区分大小写开关，abc 匹配
    //不区分大小地进行匹配，(?-i) 关闭标志，恢复不区分大小写，这时的 def 只能匹配 def
    @Test
    public void test2(){
        //(?i)--开启忽略大小写，但是只适合ASCII字符
        Pattern p = Pattern.compile("(?i)hxw");
       Matcher m = p.matcher("This is a test say hxw hello.\n"+"Wello SayHXW \nello?");
        System.out.println("参数为(?i)");
        while(m.find()){
            System.out.println(m.group());
        }
        System.out.println("-------------");

        //(?-i)--关闭忽略大小写
        p = Pattern.compile("(?-i)hxw");
        m = p.matcher("This is a test sayhxw hello.\n"+"Wello SayHXW \nello?");
        System.out.println("参数为(?-i)");
        while(m.find()){
            System.out.println(m.group());
        }

        System.out.println("----------------------------");


        //(?m)多行模式下，\n 或\r\n 作为行的分隔符，不匹配(.)
        p = Pattern.compile("(?m).ello");
        String str = "This is a test say hello.\n"+ "Wello say \nello?";
        System.out.println(str);
        m = p.matcher(str);
        System.out.println("参数为(?m)，多行模式");
        while(m.find()){
            System.out.println(m.group());
        }
        /*
        输出：
            This is a test say hello.
            Wello say
            ello?
            参数为(?m)
            hello
            Wello
        */

        System.out.println("-----------------------------------");

        //(?s) 单行模式下，.可以匹配任何字符(包括\n)
        p = Pattern.compile("(?s).ello");
        m = p.matcher("This is a test say hello.\n"+ "Wello say \nello?");
        System.out.println("参数为(?s),单行模式");
        while(m.find()){
            System.out.println(m.group());
        }


        System.out.println("-----------------------------------------");

        /*(?d)模式，启动UNIX行模式，识别\n
        UNIX 行: \n
        WINDOWS 行：\r\n
        */
        p = Pattern.compile("(?d)ello.");
        str = "This is a test say hello\r\n"+ "Wello say \nello?";
        System.out.println(str);
        m = p.matcher(str);
        System.out.println("参数为(?d)");
        while(m.find()){
            System.out.println( m.group() + "start:" + m.start() + "end:" + m.end() );
        }
        //单独使用(?d)能依据\n 和\r\n 来分行

    }

}
