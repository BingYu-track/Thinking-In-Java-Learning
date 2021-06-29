package annotations.simplest;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
/**
 * @version 1.0
 * @Description:
 * @author: bingyu
 * @date: 2021/6/29
 */
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.METHOD,
        ElementType.CONSTRUCTOR,
        ElementType.ANNOTATION_TYPE,
        ElementType.PACKAGE, ElementType.FIELD,
        ElementType.LOCAL_VARIABLE}) //声明了几乎所有的目标类型（除了 PACKAGE）
public @interface Simple {
    String value() default "-default-";
}
