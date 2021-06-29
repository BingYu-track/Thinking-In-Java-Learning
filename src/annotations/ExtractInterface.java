package annotations;
import java.lang.annotation.*;
/**
 * @version 1.0
 * @Description: 旧版本
 * @author: bingyu
 * @date: 2021/6/28
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ExtractInterface {

    public String value();
}
