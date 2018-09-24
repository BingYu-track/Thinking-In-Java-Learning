package generics;

/**
 * @version 1.0
 * @Description: 泛型巧妙实现堆栈(重要)
 * @author: hxw
 * @date: 2018/9/24 14:21
 */
public class LinkedStack<T> {

    /**
     * 末端哨兵
     */
    private Node<T> top = new Node<T>(); // End sentinel

    //堆栈中的节点，使用静态内部类
    private static class Node<U> {
        U item;// 节点的值
        Node<U> next;// 下一个节点
        Node() {
            item = null;
            next = null;
        }
        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        /**
         * 用于判断堆栈是否为空，也就是是否遇到了末端哨兵(end sentinel)
         * @return
         */
        boolean end() {
            return item == null && next == null;
        }
    }

    /**
     * 入栈
     * @param item
     */
    public void push(T item) {
        //关键代码
        top = new Node<T>(item, top); //当有新值插入的时候，改变top的指向，并将之前的top的引用赋给next
    }

    /**
     * 出栈
     * @return
     */
    public T pop() {
        //出栈的时候，每次都取栈顶的值
        T result = top.item;
        //判断是否遇到了末端哨兵
        if(!top.end()){
            top = top.next; //将下一个引用赋给当前top
        }
        return result;
    }
    public static void main(String[] args) {
        LinkedStack<String> lss = new LinkedStack<String>();
        for(String s : "Phasers on stun!".split(" ")){
            lss.push(s);
        }
        String s;
        while((s = lss.pop()) != null)
            System.out.println(s);
    }
    /*
    这个例子中使用了一个末端哨兵来判断堆栈何时为空。这个末端哨兵是在构造LinkedStack的时候创建的，然后，每调用一次push()方法，
    就会创建一个Node<T>对象，并将其连接到前一个Node<T>对象。当你调用pop()方法时，总是返回top.item，然后丢弃当前top所指的Node<T>,
    并将top转移到下一个Node<T>,除非你已经碰到了末端哨兵，这个时候就不能再移动top了。如果已经到了末端，客户端程序还继续调用pop()方法，
    它只能得到null,说明堆栈已经空了。当堆栈为空的时候，这个末端哨兵就为空了，当往堆栈里面添加数据的时候，末端哨兵被压入底部
    */
}
