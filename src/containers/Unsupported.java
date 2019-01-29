package containers;

import java.util.*;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/1/29 23:17
 */
public class Unsupported {

    static void test(String msg, List<String> list) {
        System.out.println("--- " + msg + " ---");
        Collection<String> c = list;
        Collection<String> subList = list.subList(1, 8);
        // Copy of the sublist:
        Collection<String> c2 = new ArrayList<String>(subList);
        try {
            c.retainAll(c2);
        } catch (Exception e) {
            System.out.println("retainAll(): " + e);
        }

        try {
            c.removeAll(c2);
        } catch (Exception e) {
            System.out.println("removeAll(): " + e);
        }

        try {
            c.clear();
        } catch (Exception e) {
            System.out.println("clear(): " + e);
        }

        try {
            c.add("X");
        } catch (Exception e) {
            System.out.println("add(): " + e);
        }

        try {
            c.addAll(c2);
        } catch (Exception e) {
            System.out.println("addAll(): " + e);
        }

        try {
            c.remove("C");
        } catch (Exception e) {
            System.out.println("remove(): " + e);
        }

        // The List.set() method modifies the value but doesn’t change the size of the data structure:
        try {
            list.set(0, "X");
        } catch (Exception e) {
            System.out.println("List.set(): " + e);
        }

    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A B C D E F G H I J K L".split(" "));
        test("Modifiable Copy", new ArrayList<String>(list));
        test("Arrays.asList()", list);
        List<String> strings = new ArrayList<>(list);
        test("unmodifiableList()", Collections.unmodifiableList(strings)); //Collections.unmodifiableList()返回不可修改的列表
    }
    /*
    总结：Arrays.asList()会生成基于一个固定大小数组的List，因此它仅支持那些不会改变数组大小的操作，任何会引起对底层数据结构的尺寸
    修改的方法都会产生一个UnsupportedOperationException
    * */
}
