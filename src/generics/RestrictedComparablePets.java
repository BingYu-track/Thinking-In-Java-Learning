package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/11 23:31
 */
public class RestrictedComparablePets {

    class Hamster extends ComparablePet implements Comparable<ComparablePet> {
        public int compareTo(ComparablePet arg) {  //Hamster可以再次实现与其父类ComparablePet相同的泛型接口，但前提是，类型参数要保持一致
            return 0;
        }
    }

    // Or just:
    class Gecko extends ComparablePet {
        public int compareTo(ComparablePet arg) {
            return 0;
        }
    }
}
