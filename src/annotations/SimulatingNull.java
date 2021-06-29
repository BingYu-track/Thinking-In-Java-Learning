package annotations;
import java.lang.annotation.*;
/**
 * @version 1.0
 * @Description:
 * @author: bingyu
 * @date: 2021/6/27
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SimulatingNull {

    public int id() default -1; //
    public String description() default ""; //注意非基本类型的元素，在注解源代码声明中都不能以null作为默认值，必须我们自己自定义特殊的值来表示该元素不存在

}
