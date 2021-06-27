package annotations;
import enumerated.Outcome;
import net.mindview.atunit.Test;

import java.lang.annotation.*;
/**
 * @version 1.0
 * @Description: 自定义注解，以及注解中允许的出现的类型
 * @author: bingyu
 * @date: 2021/6/26
 */
@Target(ElementType.METHOD) //@Target是个元注解，用来定义你自己的注解将要用到什么地方
@Retention(RetentionPolicy.RUNTIME) //@Retention也是个元注解，用来定义你的注解在哪一级(source、class、runtime)可以用
public @interface UseCase { //注解也会被编译成.class文件，自定义注解是需要元注解的



    public int id();
    public String description() default "no description";
    public short id2();
    public float id3();
    public boolean id4();
    public long id5();
    public Outcome id6(); //枚举
    public Class id7(); //Class
    public Test id8(); //注解


    //public Object id(); //报错，不能用Object类型作为注解的元素

    //包装类型均不能作为注解的元素
//    public Long id9();
//    public Integer id10();
}
