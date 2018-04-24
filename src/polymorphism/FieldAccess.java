package polymorphism;

/**
* @Description:多态的缺陷
* @Author:hxw
* @Date:2018/4/6 16:40
*/
public class FieldAccess {

    public static void main(String[] args){
        Super sup = new Sub();
        System.out.println("sup.field =" + sup.field + ", sup.getField() = " + sup.getField());
        //执行结果：sup.field =0, sup.getField() = 1
        //这里只有sup.getField()具有多态性,sup的引用虽然是Super类型，但实例是Sub类型，按照多态，sup.field应该是Sub类型的field=1
        Sub sub = new Sub();
        System.out.println("sub.field =" + sub.field + ", sub.getField() = " + sub.getField() + ", sub.getSuperField() = " + sub.getSuperField());
        //执行结果：sub.field =1, sub.getField() = 1, sub.getSuperField() = 0
        //总结：发现对象成员属性的访问不具有多态，那是因为任何域的访问操作都将由编译器解析，因此不具有多态型。

        System.out.println(sup.staticGet()); //执行结果：Super staticGet()
        System.out.println(sub.staticGet());//执行结果：Sub staticGet()
        //总结：发现如果方法是静态的，它的行为也不具有多态，因为静态方法是与类而并非单个对象有关。
    }
}
