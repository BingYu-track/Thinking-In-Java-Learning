package generics;

import net.mindview.util.Generator;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/24 7:59
 */
public class Fill2 {

    // Classtoken version:
    public static <T> void fill(Addable<T> addable, Class<? extends T> classToken, int size) {
        for(int i = 0; i < size; i++)
            try {
                addable.add(classToken.newInstance());
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
    }

    // Generator version:
    public static <T> void fill(Addable<T> addable, Generator<T> generator, int size) {
        for(int i = 0; i < size; i++)
            addable.add(generator.next());
    }
}
