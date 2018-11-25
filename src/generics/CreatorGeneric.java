package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/11/25 16:47
 */
public class CreatorGeneric {
    public static void main(String[] args) {
        Creator c = new Creator(); //创建Creator对象之前会调用父类GenericWithCreate构造器并执行element = create();
        c.f();
    }
}
