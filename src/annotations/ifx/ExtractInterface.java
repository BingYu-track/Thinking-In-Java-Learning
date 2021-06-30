package annotations.ifx;
import java.lang.annotation.*;

/**
 * @version 1.0
 * @Description:
 * @author: bingyu
 * @date: 2021/6/30
 */
//Here is an annotation for extracting the public methods from a class, so they can be
//turned into an interface  这是一个可以从类中提取公共方法的注解，这些方法会被转化到接口里
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ExtractInterface { //

    String interfaceName() default "-!!-";
}
