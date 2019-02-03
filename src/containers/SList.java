package containers;
import java.util.NoSuchElementException;

/**
 * @version 1.0
 * @Description: 循环链表代码实现，有待理解(插入和删除是特别耗时的,作为一个额外的练习,试着提高速度。提示:去掉搜索循环。)
 * @author: hxw
 * @date: 2019/2/3 0:17
 */
class SList<T> {

    // Utilization of the 'Null Object' pattern  头结点
    private final Link<T> header = new Link<T>(null, null);

    SList() {
        header.next = header; //循环引用
    }

    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        for(SListIterator<T> it = iterator(); it.hasNext();) {
            T element = it.next();
            buf.append(element == this ? "(this SList)" : String.valueOf(element));
            if(it.hasNext()){
                buf.append(", ");
            }
        }
        buf.append("]");
        return buf.toString();
    }

    public SListIterator<T> iterator() {
        return new SListIteratorImpl();
    }

    //类似链表的结点
    private static class Link<T> {
        T element;
        Link<T> next;
        Link(T element, Link<T> next) {
            this.element = element;
            this.next = next;
        }
    }

    private class SListIteratorImpl implements SListIterator<T> {
        private Link<T> lastReturned = header;
        private Link<T> next;

        SListIteratorImpl() { //初始化获取头结点的后继结点
            next = header.next;
        }

        public boolean hasNext() {
            return next != header; //(作者这里创建的是循环链表，最后一个结点是与头结点相连接)next与header不是同一个元素，表示有下一个；如果是同一个元素，表示没有下一个元素
        }

        public T next() {
            if (next == header)
                throw new NoSuchElementException();
            lastReturned = next;
            next = next.next;
            return lastReturned.element;
        }

        public void remove() {
            if (lastReturned == header){
                throw new IllegalStateException();
            }

            // Find an element before the last returned one
            for (Link<T> curr = header; ; curr = curr.next){
                if (curr.next == lastReturned) {
                    curr.next = lastReturned.next;
                    break;
                }
            }

            lastReturned = header;
        }

        public void add(T element) {
            lastReturned = header;
            Link<T> newLink = new Link<T>(element, next); //头部插入新的链表结点
            if (header.next == header) {
                header.next = newLink; //新的链表结点与旧结点header循环引用
            }else {
                // Find an element before the one pointed by 'next' 在“下一个”指向的元素之前找到一个元素
                for (Link<T> curr = header; ; curr = curr.next){
                    if (curr.next == next) {
                        curr.next = newLink;
                        break;
                    }
                }
            }

        }

    }

}
