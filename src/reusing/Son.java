package reusing;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/1 22:35
 */
public class Son extends Father{

    public static void main(String[] args){
        Son son = new Son();
        son.tell();
        /*输出hxwman ，从这里可以知道，说明子类可以间接访问父类的私有属性；在oracle官方文档上是说子类无法继承父类的私有属性，
        但可以通过父类的public或protected方法访问。但我更倾向与这样理解："子类是能继承父类的私有属性的，但子类不能直接访问父类的私有属性"。
        * */
    }
}
