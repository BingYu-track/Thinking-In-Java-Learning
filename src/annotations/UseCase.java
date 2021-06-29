package annotations;
import enumerated.Outcome;
import net.mindview.atunit.Test;

import java.lang.annotation.*;
/**
 * @version 1.0
 * @Description: 自定义注解
 * @author: bingyu
 * @date: 2021/6/26
 */
@Target(ElementType.METHOD) //@Target是个元注解，用来定义你自己的注解将要用到什么地方
@Retention(RetentionPolicy.RUNTIME) //@Retention也是个元注解，用来定义你的注解在哪一级(source、class、runtime)可以用
public @interface UseCase { //注解也会被编译成.class文件，自定义注解是需要元注解的


    //注解的参数: 参数类型 + 参数名()
    public int id(); //还有，如果注解参数没有定义默认值，则使用时，必须给该参数赋值，否则编译器就会报错
    //注意，这里不要理解成方法了
    public String description() default "no description";

}
