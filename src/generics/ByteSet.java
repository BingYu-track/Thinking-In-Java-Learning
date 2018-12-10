package generics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/10 23:51
 */
public class ByteSet {
    Byte[] possibles = { 1,2,3,4,5,6,7,8,9 };
    Set<Byte> mySet = new HashSet<Byte>(Arrays.asList(possibles));
    // But you can’t do this: 因为泛型不接受基本类型，所以需要向上面的代码封装成Byte包装类型数组
    // Set<Byte> mySet2 = new HashSet<Byte>(Arrays.<Byte>asList(1,2,3,4,5,6,7,8,9));
}
