package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Description: 通配符
 * @author: hxw
 * @date: 2018/12/3 23:42
 */
public class GenericsAndCovariance {

    public static void main(String[] args) {
        Fruit[] fruit = new Apple[10];
        //List<Fruit> flist = new ArrayList<Apple>();  Compile Error: incompatible types:
        //上面无法直接向数组那样，但如果加上通配符，就允许,但是这样做就无法向其添加任何类型的对象
        List<? extends Fruit> flist = new ArrayList<Apple>();
        // Compile Error: can’t add any type of object:编译错误无法添加任何对象
        //flist.add(new Apple());
        // flist.add(new Fruit());
        // flist.add(new Object());
        flist.add(null); // 合法却无意义
        // We know that it returns at least Fruit: 但允许你返回对象
        Fruit f = flist.get(0);
    }
}
