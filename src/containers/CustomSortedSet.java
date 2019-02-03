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
    // If this sorted set is backed by an another one :如果此排序集由另一个排序集支持
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
        checkForNull(o);
        int ip = binarySearch((List<Comparable<T>>)list, o);
        if(ip < 0) {
            ip = -(ip + 1);
            if(ip == list.size())
                list.add(o);
            else
                list.add(ip, o);
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

    public boolean equals(Object o) {
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
        checkForValidIndex(fromIndex);
        checkForValidIndex(toIndex);
        try {
            return new CustomSortedSet<T>(list.subList(fromIndex, toIndex));
        } catch(IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public SortedSet<T> headSet(T toElement) {
        checkForNull(toElement);
        int toIndex = list.indexOf(toElement);
        checkForValidIndex(toIndex);
        try {
            return new CustomSortedSet<T>(list.subList(0, toIndex));
        } catch(IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public SortedSet<T> tailSet(T fromElement) {
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
    private void checkForNullElements(Collection<?> c) {
        for(Iterator<?> it = c.iterator(); it.hasNext();){
            if(it.next() == null){
                throw new NullPointerException();
            }
        }
    }

    private void checkForNull(Object o) {
        if(o == null){
            throw new NullPointerException();
        }
    }

    private void checkForValidIndex(int idx) {
        if(idx == -1){
            throw new IllegalArgumentException();
        }
    }

}
