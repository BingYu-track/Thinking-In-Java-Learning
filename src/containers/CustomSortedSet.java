package containers;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotated;

import static java.util.Collections.binarySearch;

import java.util.*;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/3 17:54
 */
class CustomSortedSet<T> implements SortedSet<T> {

    private final List<T> list;


    public CustomSortedSet() {
        list = new LinkedList<T>();
    }
    //私有构造器
    // If this sorted set is backed by an another one :如果此排序集由另一个排序集作为底层支持
    private CustomSortedSet(List<T> list) {
        this.list = list;
    }
    public String toString() {
        return list.toString();
    }

    /*** Methods defined in the Collection interface ***/
    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @SuppressWarnings("unchecked")
    public boolean contains(Object o) { //重要(使用Collections类的binarySearch方法)
        checkForNull(o);
        return binarySearch((List<Comparable<T>>)list, (T)o) >= 0; //同样，要想使用binarySearch()方法Comparable接口，元素必须要实现 如果搜索键包含在列表中，则返回搜索键的索引；否则返回 (-(插入点) - 1)。
        //binarySearch((List<Comparable<T>>)list, (T)o) >= 0说明list中没有找到
    }
    public Iterator<T> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }

    @SuppressWarnings("unchecked")
    public boolean add(T o) { //重要
        checkForNull(o); //检查该对象是否为null
        int ip = binarySearch((List<Comparable<T>>)list, o); //判断list是否存在o元素
        if(ip < 0) {
            ip = -(ip + 1); //ip<0说明o不存在list里，获取插入点(第一个大于查找元素所在的数组的位置)并赋给ip
            if(ip == list.size()) //如果ip的值与list大小相同，说明该list说有值均小于ip,直接新增
                list.add(o);
            else
                list.add(ip, o); //在插入点插入o对象
            return true;
        }
        return false;
    }

    public boolean remove(Object o) {
        checkForNull(o);
        return list.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        checkForNull(c);
        return list.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        checkForNull(c);
        checkForNullElements(c);
        boolean res = false;
        for(T item : c)
            res |= add(item);
        return res;
    }

    public boolean removeAll(Collection<?> c) {
        checkForNull(c);
        return list.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        checkForNull(c);
        return list.retainAll(c);
    }

    public void clear() {
        list.clear();
    }

    public boolean equals(Object o) { //是CustomSortedSet类型，并且内部的list要相同
        return o instanceof CustomSortedSet && list.equals(((CustomSortedSet<?>)o).list);
    }
    public int hashCode() { return list.hashCode(); }

    /*** Methods defined in the SortedSet interface ***/
    public Comparator<? super T> comparator() {
        return null;
    }

    public SortedSet<T> subSet(T fromElement, T toElement) {
        checkForNull(fromElement);
        checkForNull(toElement);
        int fromIndex = list.indexOf(fromElement);
        int toIndex = list.indexOf(toElement);
        checkForValidIndex(fromIndex); //这里主要验证index是否为-1,因为indexOf()如果没有找到元素，返回的就是-1
        checkForValidIndex(toIndex);
        try {
            return new CustomSortedSet<T>(list.subList(fromIndex, toIndex));
        } catch(IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public SortedSet<T> headSet(T toElement) { //小于toElement的子集
        checkForNull(toElement);
        int toIndex = list.indexOf(toElement);
        checkForValidIndex(toIndex);
        try {
            return new CustomSortedSet<T>(list.subList(0, toIndex));
        } catch(IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public SortedSet<T> tailSet(T fromElement) { //大于等于fromElement的子集
        checkForNull(fromElement);
        int fromIndex = list.indexOf(fromElement);
        checkForValidIndex(fromIndex);
        try {
            return new CustomSortedSet<T>(
                    list.subList(fromIndex, list.size())
            );
        } catch(IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public T first() {
        try {
            return list.get(0);
        } catch(IndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
    }

    public T last() {
        try {
            return list.get(list.size() - 1);
        } catch(IndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
    }

    /*** Utility methods ***/
    //验证集合中是否有空对象
    private void checkForNullElements(Collection<?> c) {
        for(Iterator<?> it = c.iterator(); it.hasNext();){
            if(it.next() == null){
                throw new NullPointerException();
            }
        }
    }

    //验证对象是否为空值
    private void checkForNull(Object o) {
        if(o == null){
            throw new NullPointerException();
        }
    }
     //验证index
    private void checkForValidIndex(int idx) {
        if(idx == -1){
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args){
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,8));
        System.out.println(list);
        int i = binarySearch(list, 6);
        System.out.println(i); //-6
        /*list.add(5,6);
        System.out.println(list);*/
    }
}
