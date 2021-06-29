package annotations;

import enumerated.Outcome;
import net.mindview.atunit.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @version 1.0
 * @Description: 注解中允许的出现的类型
 * @author: bingyu
 * @date: 2021/6/27
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase2 {

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
