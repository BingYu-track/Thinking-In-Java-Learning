package typeinfo.testnullpattern;

import org.junit.Test;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/10 21:35
 */
public class Client {

     public static void main(String[] args) {
        BookFactory bookFactory = new BookFactory();
        //ConcreteBook book = bookFactory.getBook(1);
        //ConcreteBook book = bookFactory.getBook(2);
        ConcreteBook book = bookFactory.getBook(-1); //报空指针异常
         //判断book对象是否为null。
         if (book == null) {
             System.out.println("book对象为 null。");
         } else {
             book.show();
         }
    }
    /*
    这样做，确实消除了报错，但是这样做真的好吗? 你想如果在一段程序中有很多处调用getBook()方法或者有很多个客户端的话
    (比如图书馆的查询终端肯定不止一个啊)，岂不是很多处都要判断book对象是否为null？这还不算坏，如果哪一处没有判断，
    然后报错了，很有可能导致程序没法继续运行甚至崩溃。而且，你要记住，永远都不要太相信客户端程序员(Client)，不要把整个
    程序的稳定性寄托在客户端身上。还有，像上面的处理方法，当获取对象为null的时候，输出的提示信息是有客户端来定制的，
    这样岂不是把主动权交给了客户端，而不是我们系统本身？
    **/


    /**
     * 使用空对象设计模式修改后
     */
    @Test
    public void Test(){
        BookFactory01 bookFactory01 = new BookFactory01();
        Book book = bookFactory01.getBook(-1);
        book.show();
    }
}
