package innerclasses;

/**
* @Description: 通过匿名内部类实现多个接口，其效果与 X.java一样
* @Author:hxw
* @Date:2018/5/4 13:50
*/
public class Y implements A {

    B makeB() {
    //匿名内部类实现B接口 Anonymous inner class:
        return new B() {};
    }
}
