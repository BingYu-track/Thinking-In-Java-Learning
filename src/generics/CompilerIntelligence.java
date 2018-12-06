package generics;

import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/6 8:22
 */
public class CompilerIntelligence {

    public static void main(String[] args) {
        List<? extends Fruit> flist = Arrays.asList(new Apple());
        Apple a = (Apple)flist.get(0); // No warning
        flist.contains(new Apple()); // 这里可以调用是因为这里的参数列表是Object
        flist.indexOf(new Apple()); // Argument is ‘Object’
    }
}
