package generics;

/**
 * @version 1.0
 * @Description: LinkedStack优化
 * @author: hxw
 * @date: 2018/9/24 22:05
 */
public class LinkedStack2<T> {

    private Node top = new Node(); // End sentinel

    private class Node { //对比之前内部类去掉了泛型，发现内部类可以访问外部类泛型的"类型参数"
        T item;
        Node next;

        Node() {
            item = null;
            next = null;
        }

        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }

    }

    public void push(T item) {
        top = new Node(item, top);
    }

    public T pop() {
        T result = top.item;
        if(!top.end()){
            top = top.next;
        }
        return result;
    }

}
