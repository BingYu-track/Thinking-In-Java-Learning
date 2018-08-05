package strings;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/5 22:05
 */
public class WhitherStringBuilder {

    //使用了多个String对象
    public String implicit(String[] fields) {
        String result = "";
        for(int i = 0; i < fields.length; i++){
            result += fields[i];
        }
        return result;
    }

    //使用StringBuilder
    public String explicit(String[] fields) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < fields.length; i++){
            result.append(fields[i]);
        }
        return result.toString();
    }
}

/*
    我们再次进行反汇编来对比两个方法，发现使用了StringBuilder的explicit方法只生产了一个StringBuilder对象，因此当你在循环使用字符串
    或者进行多次复杂的字符串拼接时最好用StringBuilder对象来构造，示例见UsingStringBuilder.java。

public java.lang.String implicit(java.lang.String[]);
    Code:
       0: ldc           #2                  // String
       2: astore_2
       3: iconst_0
       4: istore_3
       5: iload_3
       6: aload_1
       7: arraylength
       8: if_icmpge     38
      11: new           #3                  // class java/lang/StringBuilder
      14: dup
      15: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V
      18: aload_2
      19: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      22: aload_1
      23: iload_3
      24: aaload
      25: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      28: invokevirtual #6                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      31: astore_2
      32: iinc          3, 1
      35: goto          5  //返回循环体起始点(第5行)
      38: aload_2
      39: areturn

  public java.lang.String explicit(java.lang.String[]);
    Code:
       0: new           #3                  // class java/lang/StringBuilder
       3: dup
       4: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V
       7: astore_2
       8: iconst_0
       9: istore_3
      10: iload_3
      11: aload_1
      12: arraylength
      13: if_icmpge     30
      16: aload_2
      17: aload_1
      18: iload_3
      19: aaload
      20: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      23: pop
      24: iinc          3, 1
      27: goto          10
      30: aload_2
      31: invokevirtual #6                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      34: areturn
}


 */
