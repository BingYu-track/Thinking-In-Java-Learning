package strings;

/**
 * @version 1.0
 * @Description: 字符串拼接内部剖析
 * @author: hxw
 * @date: 2018/8/5 21:28
 */
public class Concatenation {

    public static void main(String[] args) {
        String mango = "mango";
        String s = "abc" + mango + "def" + 47;
        System.out.println(s);
    }
}
/*通过javap -c Concatenation.class文件反汇编获得以下信息(注意，要使javap命令有效，必须在Path上添加Javahome/bin的路路径，
    我的是C:\Program Files\Java\jdk1.8.0_171\bin)，从以下信息我们知道编译器创建了StringBuilder对象，并为每个字符串调用了
    StringBuilder的append()方法，一共四次 ，最后调用toString()方法生成最终结果，虽然编译器自动优化了字符串拼接性能，但并不意味着
    你能随意这样使用String对象。

public class strings.Concatenation {
  public strings.Concatenation();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: ldc           #2                  // String mango
       2: astore_1
       3: new           #3                  // class java/lang/StringBuilder
       6: dup
       7: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V
      10: ldc           #5                  // String abc
      12: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      15: aload_1
      16: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      19: ldc           #7                  // String def
      21: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      24: bipush        47
      26: invokevirtual #8                  // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
      29: invokevirtual #9                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      32: astore_2
      33: getstatic     #10                 // Field java/lang/System.out:Ljava/io/PrintStream;
      36: aload_2
      37: invokevirtual #11                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      40: return
}


*/
