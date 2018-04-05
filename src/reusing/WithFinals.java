package reusing;

/**
* @Description:final方法
* @Author:hxw
* @Date:2018/4/5 16:21
*/
public class WithFinals {

    private final void f(){
        System.out.println("WithFinals调用f方法");
    }

    private void g(){   //类中所有的private方法都隐式地指定为final
        System.out.println("WithFinals调用g方法");
    }
}
