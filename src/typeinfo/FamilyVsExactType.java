package typeinfo;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/5 21:20
 */
public class FamilyVsExactType {

    static void test(Object x) {
        print("Testing x of type " + x.getClass());
        print("x instanceof Base " + (x instanceof Base));
        print("x instanceof Derived "+ (x instanceof Derived));
        print("Base.isInstance(x) "+ Base.class.isInstance(x));
        print("Derived.isInstance(x) " + Derived.class.isInstance(x));
        print("x.getClass() == Base.class " + (x.getClass() == Base.class));
        print("x.getClass() == Derived.class " + (x.getClass() == Derived.class));
        print("x.getClass().equals(Base.class)) "+ (x.getClass().equals(Base.class)));
        print("x.getClass().equals(Derived.class)) " + (x.getClass().equals(Derived.class)));
    }
    public static void main(String[] args) {
        test(new Base());
        test(new Derived());
    }
    /*
    总结：在上面的示例中我们发现，instanceof和isInstance()生成的结果是完全相同的，equals和==比较的结果也一样;
          instanceof和isInstance()指"你是这个类吗，或者是这个类的子类吗?"而如果用equals和==比较实际的Class
          对象就没有考虑继承------它指是否是这个确切的类型。
    */
}
