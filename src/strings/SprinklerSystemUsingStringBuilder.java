package strings;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/5 22:43
 */
public class SprinklerSystemUsingStringBuilder {

    private String valve1, valve2, valve3, valve4;
    private WaterSource source = new WaterSource();
    private int i;
    private float f;
    public String toString() {
        StringBuilder result = new StringBuilder("valve1 = ");
        result.append(valve1).append(" ")
              .append("valve2 = ").append(valve2).append(" ")
              .append("valve3 = ").append(valve3).append(" ")
              .append("valve4 = ").append(valve4).append("\n")
              .append("i = ").append(i).append("f = ").append(f).append(" ")
              .append("source = ").append(source);
        return result.toString();
    }
    public static void main(String[] args) {
        SprinklerSystemUsingStringBuilder sprinklers = new SprinklerSystemUsingStringBuilder();
        System.out.println(sprinklers);
    }
    /*
    WaterSource()
    valve1 = null valve2 = null valve3 = null valve4 = null
    i = 0f = 0.0 source = Constructed

    javap反汇编结果如下：
    public java.lang.String toString();
    Code:
       0: new           #5                  // class java/lang/StringBuilder
       3: dup
       4: ldc           #6                  // String valve1 =
       6: invokespecial #7                  // Method java/lang/StringBuilder."<init>":(Ljava/lang/String;)V
       9: astore_1
      10: aload_1
      11: aload_0
      12: getfield      #8                  // Field valve1:Ljava/lang/String;
      15: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      18: ldc           #10                 // String
      20: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      23: ldc           #11                 // String valve2 =
      25: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      28: aload_0
      29: getfield      #12                 // Field valve2:Ljava/lang/String;
      32: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      35: ldc           #10                 // String
      37: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      40: ldc           #13                 // String valve3 =
      42: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      45: aload_0
      46: getfield      #14                 // Field valve3:Ljava/lang/String;
      49: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      52: ldc           #10                 // String
      54: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      57: ldc           #15                 // String valve4 =
      59: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      62: aload_0
      63: getfield      #16                 // Field valve4:Ljava/lang/String;
      66: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      69: ldc           #17                 // String \n
      71: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      74: ldc           #18                 // String i =
      76: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      79: aload_0
      80: getfield      #19                 // Field i:I
      83: invokevirtual #20                 // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
      86: ldc           #21                 // String f =
      88: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      91: aload_0
      92: getfield      #22                 // Field f:F
      95: invokevirtual #23                 // Method java/lang/StringBuilder.append:(F)Ljava/lang/StringBuilder;
      98: ldc           #10                 // String
     100: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
     103: ldc           #24                 // String source =
     105: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
     108: aload_0
     109: getfield      #4                  // Field source:Lstrings/WaterSource;
     112: invokevirtual #25                 // Method java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
     115: pop
     116: aload_1
     117: invokevirtual #26                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
     120: areturn

        比较SprinklerSystem反汇编的结果发现，这次显示使用StringBuilder效率并不比String +的方式更好
        结论：在针对这种没有循环但是有变变量拼接的字符串时，使用StringBuilder与使用String + 的方式没有区别，但是String + 的方式更加省时省力，而且相对清晰。
    */
}
