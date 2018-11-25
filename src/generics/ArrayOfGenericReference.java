package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/11/25 21:21
 */
public class ArrayOfGenericReference {


    static Generic<Integer>[] gia; //这个泛型数组可以声明，但是永远无法创建这个数组，但是使用通配符创建泛型数组是可以的

    // static Generic<Integer>[] gia = new Generic<Integer>[10]; ERROR
    static Generic<?>[] gib = new Generic<?>[10];
}
