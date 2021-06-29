package annotations.database;
import java.lang.annotation.*;
/**
 * @version 1.0
 * @Description:
 * @author: bingyu
 * @date: 2021/6/27
 */
@Target(ElementType.TYPE)
//@Target({ElementType.TYPE,ElementType.PARAMETER}) 定义多个约束，用逗号分割，
// 如果要将该注解应用于所有的ElementType，就可以直接省去@Target元注解
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
    public String name() default "";
}
