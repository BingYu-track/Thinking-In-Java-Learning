package holding;

import java.util.*;

public class AddingGroups {

    public static void main(String[] args){
        Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));  //Collection的构造器可以接收另一个Collection来初始化
        Integer[] moreInts = { 6, 7, 8, 9, 10 };
        collection.addAll(Arrays.asList(moreInts));  //将moreInts首先转换为list，再将其所有的元素添加到collection中
        Collections.addAll(collection, 11, 12, 13, 14, 15);//作用同上 Collections.addAll()方法运行速度要快得多
        Collections.addAll(collection, moreInts);
        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);//注意：由Arrays.asList生成的List实际上底层表示的是数组，因此不能调整size
        list.set(1, 99); // OK -- modify an element
        list.add(21); // 运行时错误，因为无法调整基础数组的大小。
    }
    /*
    注意：Collection的构造器可以接收另一个Collection来初始化。例如：new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
    这里调用ArrayList的构造器传入一个list来初始化自己。
    1.Collections.addAll(Collection<? super T> c, T... elements)方法需要传入两个参数一个是Collection,另一个是可变参(数组或
    多个参数列表)，将其元素加入第一个参数Collection中。
    2.collection.addAll()--将指定 collection 中的所有元素都添加到此 collection 中
    * */
}
