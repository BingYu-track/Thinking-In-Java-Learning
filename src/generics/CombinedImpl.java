package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/10/7 21:10
 */
class CombinedImpl implements Top{
    public void a() { System.out.println("Top::a()"); }
    public void b() { System.out.println("Top::b()"); }
    public void c() {
        System.out.println("CombinedImpl::c()");
    }
}
