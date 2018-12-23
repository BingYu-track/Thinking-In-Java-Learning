package generics;

import java.util.Collection;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/23 23:25
 */
public class Fill {

    public static <T> void fill(Collection<T> collection, Class<? extends T> classToken, int size) {
        for(int i = 0; i < size; i++){
            // Assumes default constructor:
            try {
                collection.add(classToken.newInstance());
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
