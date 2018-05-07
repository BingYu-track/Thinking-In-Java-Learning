package innerclasses;

/**
* @Description: 内部类的继承
* @Author:hxw
* @Date:2018/5/7 16:42
*/
public class InheritInner extends WithInner.Inner {

    //! InheritInner() {} // 无法编译
    InheritInner(WithInner wi) {   //必须要给其一个外部类的引用，并且在构造器中加入enclosingClassReference.super();
        wi.super();
    }
    public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);
    }
}
