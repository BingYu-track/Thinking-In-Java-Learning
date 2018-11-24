package generics;

/**
 * @version 1.0
 * @Description: 明确指定了其持有对象的类型Automobile，代码约束性很强
 * @author: hxw
 * @date: 2018/9/23 19:02
 */
public class Holder1 {

    private Automobile a;
    public Holder1(Automobile a) {
        this.a = a;
    }

    Automobile get() {
        return a;
    }
}
