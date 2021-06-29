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
public @interface Constraints {

    boolean primaryKey() default false;
    boolean allowNull() default true;
    boolean unique() default false;
}
