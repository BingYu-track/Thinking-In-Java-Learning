package typeinfo.testnullpattern;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/10 21:45
 */
public class BookFactory01 {
    /**
     * Description About getBook: <br>
     * 根据ConcreteBook的ID，获取图书对象。
     * @param ID 图书的ID
     * @return 图书对象
     * @version V1.0
     */

    public Book getBook(int ID) {
        Book book;//将原来的ConcreteBook改为Book
        switch (ID) {
            case 1:
                book = new ConcreteBook01(ID, "设计模式", "GoF");
                break;
            case 2:
                book = new ConcreteBook01(ID, "被遗忘的设计模式", "Null Object Pattern");
                break;
            default:
                book = new NullBook();//创建一个NullBook对象
                break;
        }

        return book;
    }
}
