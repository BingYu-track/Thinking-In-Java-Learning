package containers;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @version 1.0
 * @Description: 模拟使用各种Set ，其对象类型必须实现的类型：SetType、HashType、TreeType
 * @author: hxw
 * @date: 2019/2/3 11:19
 */
public class TypesForSets {

    static <T> Set<T> fill(Set<T> set, Class<T> type) {
        try {
            for(int i = 0; i < 10; i++)
                set.add(
                        type.getConstructor(int.class).newInstance(i) //使用反射调用有参构造创建对象
                );
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
        return set;
    }

    static <T> void test(Set<T> set, Class<T> type) {
        fill(set, type);
        fill(set, type); // Try to add duplicates
        fill(set, type);
        System.out.println(set);
    }

    public static void main(String[] args) {
        test(new HashSet<HashType>(), HashType.class); //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        test(new LinkedHashSet<HashType>(), HashType.class); //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        test(new TreeSet<TreeType>(), TreeType.class); //[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
        // Things that don’t work: 没有提供hashCode方法，导致所有Set里的元素都重复了(原因后面揭晓)
        test(new HashSet<SetType>(), SetType.class); //[6, 3, 7, 9, 8, 9, 3, 4, 7, 8, 2, 4, 1, 1, 2, 3, 0, 5, 6, 5, 9, 2, 4, 8, 7, 0, 6, 1, 0, 5]
        test(new HashSet<TreeType>(), TreeType.class); //[8, 7, 3, 9, 1, 1, 3, 5, 4, 1, 2, 4, 3, 5, 0, 9, 7, 8, 4, 7, 6, 6, 2, 6, 0, 0, 9, 2, 5, 8]
        test(new LinkedHashSet<SetType>(), SetType.class); //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        test(new LinkedHashSet<TreeType>(), TreeType.class); //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        try {
            test(new TreeSet<SetType>(), SetType.class); //java.lang.ClassCastException: containers.SetType cannot be cast to java.lang.Comparable
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            test(new TreeSet<HashType>(), HashType.class); //java.lang.ClassCastException: containers.HashType cannot be cast to java.lang.Comparable
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
