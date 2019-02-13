//: net/mindview/util/PPrint.java
// Pretty-printer for collections
package net.mindview.util;
import java.util.*;

/**
* @Description: 容器打印工具类，具有缩排，增行，打印界面更加友好
* @Author:hxw
* @Date:2019/2/13 21:29
*/
public class PPrint {
  public static String pformat(Collection<?> c) {
    if(c.size() == 0) {
      return "[]";
    }
    StringBuilder result = new StringBuilder("[");
    for(Object elem : c) {
      if(c.size() != 1){
        result.append("\n  ");
      }
      result.append(elem);
    }
    if(c.size() != 1){
      result.append("\n");
    }
    result.append("]");
    return result.toString();
  }

  public static void pprint(Collection<?> c) {
    System.out.println(pformat(c));
  }

  public static void pprint(Object[] c) {
    System.out.println(pformat(Arrays.asList(c)));
  }

} ///:~
