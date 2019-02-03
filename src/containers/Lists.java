package containers;

import net.mindview.util.Countries;
import net.mindview.util.*;

import java.util.*;

import static net.mindview.util.Print.*;
/**
 * @Description:
 * @author: hxw
 * @version 1.0
 * @date: 2019/1/31 11:01
 */
public class Lists {

    private static boolean b;
    private static String s;
    private static int i;
    private static Iterator<String> it;
    private static ListIterator<String> lit;

    //测试List基本操作
    public static void basicTest(List<String> a) {
        a.add(1, "x"); // Add at location 1 插入到索引位置为1的位置
        a.add("x"); // Add at end
        // Add a collection: 添加collection
        a.addAll(Countries.names(25));
        // Add a collection starting at location 3: 将collection插入到索引为3的位置
        a.addAll(3, Countries.names(25));
        b = a.contains("1"); // Is it in there?
        // Is the entire collection in there? 是否包含一个集合
        b = a.containsAll(Countries.names(25));
        // Lists allow random access, which is cheap for ArrayList, expensive for LinkedList:
        //List允许访问元素，ArrayList开销便宜，LinkedList开销昂贵
        s = a.get(1); // Get (typed) object at location 1 获取索引为1位置上的元素
        i = a.indexOf("1"); // Tell index of object 获取对象所在索引
        b = a.isEmpty(); // Any elements inside?
        it = a.iterator(); // Ordinary Iterator 获取普通迭代器
        lit = a.listIterator(); // ListIterator 获取List迭代器
        lit = a.listIterator(3); // Start at loc 3 从指定位置开始迭代
        i = a.lastIndexOf("1"); // Last match 返回此列表中指定元素的最后一个匹配的索引
        a.remove(1); // Remove location 1
        a.remove("3"); // Remove this object
        a.set(1, "y"); // Set location 1 to "y"
        // Keep everything that’s in the argument(the intersection of the two sets): 取交集
        a.retainAll(Countries.names(25));
        // Remove everything that’s in the argument: //差集
        a.removeAll(Countries.names(25));
        i = a.size(); // How big is it?
        a.clear(); // Remove all elements
    }

    //iterator遍历元素
    public static void iterMotion(List<String> a) {
        ListIterator<String> it = a.listIterator();
        b = it.hasNext();
        b = it.hasPrevious();
        s = it.next();
        i = it.nextIndex();
        s = it.previous();
        i = it.previousIndex();
    }

    //iterator修改元素
    public static void iterManipulation(List<String> a) {
        ListIterator<String> it = a.listIterator();
        it.add("47"); //从开头加入元素
        // Must move to an element after add(): 必须在add()之后移动到元素
        it.next();
        // Remove the element after the newly produced one: 删除新生成的元素之后的元素。
        it.remove();
        // Must move to an element after remove():
        it.next();
        // Change the element after the deleted one:
        it.set("47");
    }

    //查看效果
    public static void testVisual(List<String> a) {
        print(a);
        List<String> b = Countries.names(25);
        print("b = " + b);
        a.addAll(b);
        a.addAll(b);
        print(a);
        // Insert, remove, and replace elements using a ListIterator:
        ListIterator<String> x = a.listIterator(a.size()/2);
        x.add("one");
        print(a);
        print(x.next());
        x.remove();
        print(x.next());
        x.set("47");
        print(a);
        // Traverse the list backwards:
        x = a.listIterator(a.size());
        while(x.hasPrevious()){
            printnb(x.previous() + " ");
        }
        print();
        print("testVisual finished");
    }

    // There are some things that only LinkedLists can do: 仅仅只有LinkedLists能做到的事情
    public static void testLinkedList() {
        LinkedList<String> ll = new LinkedList<String>();
        ll.addAll(Countries.names(25));
        print(ll);
        // Treat it like a stack, pushing: 像一个栈，向下压
        ll.addFirst("one");
        ll.addFirst("two");
        print(ll);
        // Like "peeking" at the top of a stack:.
        print(ll.getFirst());
        // Like popping a stack:
        print(ll.removeFirst());
        print(ll.removeFirst());
        // Treat it like a queue, pulling elements off the tail end: 把它当作一个队列，从尾端拉出一些元素。
        print(ll.removeLast());
        print(ll);
    }

    public static void main(String[] args) {
        // Make and fill a new list each time:
        basicTest(
                new LinkedList<String>(Countries.names(25))
        );

        basicTest(
                new ArrayList<String>(Countries.names(25))
        );

        iterMotion(
                new LinkedList<String>(Countries.names(25))
        );

        iterMotion(
                new ArrayList<String>(Countries.names(25))
        );

        iterManipulation(
                new LinkedList<String>(Countries.names(25))
        );

        iterManipulation(
                new ArrayList<String>(Countries.names(25))
        );

        testVisual(
                new LinkedList<String>(Countries.names(25))
        );

        testLinkedList();
    }
}
