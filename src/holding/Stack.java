package holding;

import java.util.LinkedList;

/**
 * @version 1.0
 * @Description: LinkedList直接实现栈
 * @author: hxw
 * @date: 2018/6/19 18:09
 */
public class Stack <T>{
    private LinkedList<T> storage = new LinkedList<T>();
    public void push(T v) {
        storage.addFirst(v);
    }

    public T peek() {
        return storage.getFirst();
    }

    public T pop() {
        return storage.removeFirst();
    }

    public boolean empty() {
        return storage.isEmpty();
    }

    public String toString() {
        return storage.toString();
    }
}
