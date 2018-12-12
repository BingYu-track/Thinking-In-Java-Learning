package generics;

/**
 * @version 1.0
 * @Description: 父类限制了泛型接口(子类如果要再实现父类的泛型接口，其类型参数必须与父类一致)
 * @author: hxw
 * @date: 2018/12/11 23:24
 */
public class ComparablePet implements Comparable<ComparablePet> {


    @Override
    public int compareTo(ComparablePet o) {
        return 0;
    }
}
