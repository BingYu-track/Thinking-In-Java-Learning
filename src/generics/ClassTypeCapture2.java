package generics;
import java.util.*;
import static net.mindview.util.Print.*;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/10/9 8:20
 */
public class ClassTypeCapture2 {
    Map<String,Class<?>> types = new HashMap<String,Class<?>>();//存储类型名称和类型信息
    public Object createNew(String typename) {
        Class<?> cl = types.get(typename);
        try {
            return cl.newInstance();
        } catch(NullPointerException e) {
            print("Not a registered typename: " + typename);
        } catch(Exception e) {
            print(e.toString());
        }
        return null;
    }

    public void addType(String typename, Class<?> kind) {
        types.put(typename, kind);
    }
}
