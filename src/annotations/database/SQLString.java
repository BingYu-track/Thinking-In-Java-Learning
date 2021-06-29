package annotations.database;
import java.lang.annotation.*;
/**
 * @version 1.0
 * @Description:
 * @author: bingyu
 * @date: 2021/6/27
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLString {

    int value() default 0;
    String name() default "";
    Constraints constraints() default @Constraints; //注解里出现的注解元素类型
}
