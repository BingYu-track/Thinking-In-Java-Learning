package containers;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/3 11:14
 */
public class TreeType extends SetType implements Comparable<TreeType> {
    public TreeType(int n) {
        super(n);
    }

    //实现Comparable接口
    public int compareTo(TreeType arg) {
        return (arg.i < i ? -1 : (arg.i == i ? 0 : 1));
        //这里，没有使用return arg.i-i 的原因是由于arg.i可能是一个很大的正整数，而i可能是一个很小的负整数，它们两相减返回的值可能会溢出，超过int最大范围的值
        //而导致溢出返回负值，因此为了避免这种情况发生不要使用return arg.i-i相减这种形式

    }
}
