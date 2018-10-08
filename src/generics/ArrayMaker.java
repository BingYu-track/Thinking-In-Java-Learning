package generics;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/10/8 20:50
 */
public class ArrayMaker<T> {
    private Class<T> kind;
    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }

    @SuppressWarnings("unchecked")
        T[] create(int size) {
        System.out.println(kind.getSimpleName());
        return (T[])Array.newInstance(kind, size);//Array.newInstance(kind, size)创建一个具有指定的组件类型和长度的新数组
        //由于Array.newInstance返回的是Object，所以需要强转
    }
    public static void main(String[] args) {
        ArrayMaker<String> stringMaker = new ArrayMaker<String>(String.class);
        String[] stringArray = stringMaker.create(9);
        System.out.println(Arrays.toString(stringArray));
    }
}
