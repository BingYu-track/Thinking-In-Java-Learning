package annotations.database;
import java.lang.annotation.*;
/**
 * @version 1.0
 * @Description:
 * @author: bingyu
 * @date: 2021/6/27
 */
public @interface Uniqueness {
    Constraints constraints() default @Constraints(unique = true); //指定unique=true作为Constraints注解的默认值
}
