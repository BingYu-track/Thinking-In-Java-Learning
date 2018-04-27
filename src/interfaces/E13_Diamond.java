package interfaces;

/**
* @Description:Java中接口是如何防止C++多重继承中产生的"菱形问题"
* @Author:hxw
* @Date:2018/4/26 16:17
*/
public class E13_Diamond {

    public static void main(String[] args){
        SmallLiger smallLiger = new SmallLiger();
        smallLiger.getWeight();
    }
    /*
    在C++的继承结构中，我们可以看出Tiger和Lion类都继承自Animal基类。所以问题是：因为Liger多重继承了Tiger和Lion类，因此Liger类会有两份Animal类的成员（数据和方法），
    Liger对象"lg"会包含Animal基类的两个子对象。所以，你会问Liger对象有两个Animal基类的子对象会出现什么问题？再看看上面的代码-调用"lg.getWeight()"将会导致一个编译错误。
    这是因为编译器并不知道是调用Tiger类的getWeight()还是调用Lion类的getWeight()。所以，调用getWeight方法是不明确的，因此不能通过编译。

    而Java允许多接口继承，但不允许多个实现继承，这消除了关于两个相同成员中调用哪一个的歧义。我们在组合相同基类的实现时使用。
    我们复制weight()方法在上面的接口中演示Java避免了“菱形问题”(之所以称为“问题”，是因为由多重继承。C需要额外的基类语法来解决歧义。由具体的多重继承创建)。
    * */
}
