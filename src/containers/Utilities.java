package containers;

import java.util.*;

import static net.mindview.util.Print.print;

/**
 * @version 1.0
 * @Description: Collections的实用方法
 * @author: hxw
 * @date: 2019/2/10 11:28
 */
public class Utilities{

    static List<String> list = Arrays.asList("one Two three Four five six one".split(" "));

    public static void main(String[] args){
        print(list);
        print("‘list’ disjoint (Four)?: " +
                Collections.disjoint(
                        list, Collections.singletonList("Four")
                )
            ); //list是否与新的集合存在相同的元素，没有相同返回true，有返回false
        print("max: " + Collections.max(list));
        print("min: " + Collections.min(list));
        print("max w/ comparator: " + Collections.max(list, String.CASE_INSENSITIVE_ORDER));
        print("min w/ comparator: " + Collections.min(list, String.CASE_INSENSITIVE_ORDER));
        List<String> sublist = Arrays.asList("Four five six".split(" "));
        print("indexOfSubList: " + Collections.indexOfSubList(list, sublist)); //返回sublist在list中第一次出现的索引
        print("lastIndexOfSubList: " + Collections.lastIndexOfSubList(list, sublist));
        Collections.replaceAll(list, "one", "Yo"); //用YO替换list中所有的one
        print("replaceAll: " + list); //replaceAll: [Yo, Two, three, Four, five, six, Yo]
        Collections.reverse(list); //反转顺序
        print("reverse: " + list); //reverse: [Yo, six, five, Four, three, Two, Yo]
        Collections.rotate(list, 3); //每个元素向后移动3步
        print("rotate: " + list); //rotate: [three, Two, Yo, Yo, six, five, Four]
        List<String> source = Arrays.asList("in the matrix".split(" "));
        Collections.copy(list, source);
        print("copy: " + list); //copy: [in, the, matrix, Yo, six, five, Four]
        Collections.swap(list, 0, list.size() - 1); //首尾元素互换
        print("swap: " + list); //swap: [Four, the, matrix, Yo, six, five, in]
        Collections.shuffle(list, new Random(47));
        print("shuffled: " + list);
        Collections.fill(list, "pop");
        print("fill: " + list);
        print("frequency of ‘pop’: " + Collections.frequency(list, "pop")); //返回元素为pop在list中的元素个数
        List<String> dups = Collections.nCopies(3, "snap"); //返回大小为3的不可变list
        print("dups: " + dups);
        print("‘list’ disjoint ‘dups’?: " + Collections.disjoint(list, dups));
        // Getting an old-style Enumeration:
        Enumeration<String> e = Collections.enumeration(dups);
        Vector<String> v = new Vector<String>();
        while(e.hasMoreElements()){
            v.addElement(e.nextElement());
        }
        // Converting an old-style Vector to a List via an Enumeration:
        ArrayList<String> arrayList = Collections.list(v.elements());
        print("arrayList: " + arrayList);
    }
}
