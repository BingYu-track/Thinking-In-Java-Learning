package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/3 23:39
 */
public class NonCovariantGenerics {
    // Compile Error: incompatible types:
    //List<Fruit> flist = new ArrayList<Apple>();
}
