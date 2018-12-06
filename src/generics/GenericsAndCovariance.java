package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Description: 泛型与协变 (由于泛型不支持协变，因此使用通配符解决转型问题)
 * @author: hxw
 * @date: 2018/12/3 23:42
 */
public class GenericsAndCovariance {

    public static void main(String[] args) {
        Fruit[] fruit = new Apple[10];
        //List<Fruit> flist = new ArrayList<Apple>();  Compile Error: incompatible types:
        // 从上面一行代码知道泛型不支持协变，我们也可以这样理解，假设允许泛型协变，当List<Apple>成功转型为List<Fruit>，那么他就可以add任何Fruit的子类型了，当你尝试添加一个Orange到这List<Fruit>这明显就是错误的
        //上面无法直接向数组那样，但如果加上通配符，就允许,但是这样做就无法向其添加任何类型的对象
        List<? extends Fruit> flist = new ArrayList<Apple>();
        // Compile Error: can’t add any type of object:编译错误无法添加任何对象
        // 因为此时add()方法的参数变成? Extends Fruit,编译器并不知道这是什么类型，会拒绝对参数列表中涉及通配符方法的调用
        //flist.add(new Apple());
        // flist.add(new Fruit());
        // flist.add(new Object());
        flist.add(null); // 合法却无意义
        // We know that it returns at least Fruit: 但允许你返回对象
        Fruit f = flist.get(0);
    }
}
