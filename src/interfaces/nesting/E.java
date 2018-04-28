package interfaces.nesting;

/**
* @Description:接口中嵌套接口
* @Author:hxw
* @Date:2018/4/27 19:45
*/
interface E {
    interface G {
        void f();
    }
    // 这个public是多余的
    public interface H {
        void f();
    }
    void g();
// 不能使用private修饰interface:接口中所有的东西都是公有的
//! private interface I {}
}
