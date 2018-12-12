package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/11 23:25
 */
public class HijackedInterface {

    //由于Cat已经继承了Comparable<ComparablePet>，就不能再实现其它类型参数的Comparable接口
    /*class Cat extends ComparablePet implements Comparable<Cat> {
        // Error: Comparable 不能用不同的参数继承: <Cat> and <ComparablePet>
        public int compareTo(Cat arg) {
            return 0;
        }
    }*/
}
