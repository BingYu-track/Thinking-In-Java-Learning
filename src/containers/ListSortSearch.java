package containers;

import java.util.*;

import static net.mindview.util.Print.print;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/10 14:13
 */
public class ListSortSearch {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(Utilities.list);
        list.addAll(Utilities.list);
        print(list); //[one, Two, three, Four, five, six, one, one, Two, three, Four, five, six, one]
        Collections.shuffle(list, new Random(47));
        print("Shuffled: " + list); //Shuffled: [Four, five, one, one, Two, six, six, three, three, five, Four, Two, one, one]
        // Use a ListIterator to trim off the last elements: 使用ListIterator删除最后一个元素
        ListIterator<String> it = list.listIterator(10); //从第10个元素开始(不是索引为10)
        while(it.hasNext()) {
            String next = it.next();
            it.remove();
        }
        print("Trimmed: " + list); //Trimmed: [Four, five, one, one, Two, six, six, three, three, five]
        Collections.sort(list);
        print("Sorted: " + list); //Sorted: [Four, Two, five, five, one, one, six, six, three, three]
        String key = list.get(6);
        int index = Collections.binarySearch(list, "six"); //如果列表包含多个等于指定对象的元素，则二分法查找无法保证找到的是哪一个
        print("Location of " + key + " is " + index + ", list.get(" + index + ") = " + list.get(index));
        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        print("Case-insensitive sorted: " + list); //Case-insensitive sorted: [five, five, Four, one, one, six, six, three, three, Two]
        key = list.get(7);
        index = Collections.binarySearch(list, key, String.CASE_INSENSITIVE_ORDER);
        print("Location of " + key + " is " + index + ", list.get(" + index + ") = " + list.get(index));
    }

}
