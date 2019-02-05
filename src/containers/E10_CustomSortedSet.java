package containers;
import static net.mindview.util.Print.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;

/**
 * @version 1.0
 * @Description:  实现SortedSet的几个条件
 * 1.不需要支持额外的比较器，所以我们的SortedSet将使用元素的自然排序。
 * 2.集合将不能存放null
 * 3.我们不会为速度优化代码
 * 4.我们的排序集将只有一个公共的无参构造。
 * @author: hxw
 * @date: 2019/2/3 17:48
 */
public class E10_CustomSortedSet {

    // The whole main() method is basically copy-pasted from containers/SortedSetDemo.java!
    public static void main(String[] args) {
        SortedSet<String> sortedSet = new CustomSortedSet<String>();
        Collections.addAll(
                sortedSet, "one two three four five six seven eight".split(" ")
        );
        print(sortedSet);
        String low = sortedSet.first();
        String high = sortedSet.last();
        print(low);
        print(high);
        Iterator<String> it = sortedSet.iterator();
        for (int i = 0; i <= 6; i++) {
            if (i == 3)
                low = it.next();
            if (i == 6)
                high = it.next();
            else
                it.next(); //注意，当i=3时，it执行了两次nect()方法
        }
        print(low);
        print(high);
        print(sortedSet.subSet(low, high));
        print(sortedSet.headSet(high));
        print(sortedSet.tailSet(low));
        print(sortedSet.contains("three"));
        print(sortedSet.contains("eleven"));

        boolean b = sortedSet.addAll(Arrays.asList("three", "eleven"));
        print(b);

        print(sortedSet);
        boolean b1 = sortedSet.retainAll(Arrays.asList("three", "eleven"));
        print(b1);

        print(sortedSet);
        // Demonstrate data integrity
        try {
            sortedSet.addAll(Arrays.asList("zero", null));
        } catch(NullPointerException e) {
            System.out.println("Null elements not supported!");
        }
        // The set will not contain "zero"!
        print(sortedSet);

    }
}
