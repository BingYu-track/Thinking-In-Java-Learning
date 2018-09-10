package typeinfo.testnullpattern;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/10 21:34
 */
public class BookFactory {

    /**
     * Description About getBook: <br>
     * 根据ConcreteBook的ID，获取图书对象。
     * @param ID 图书的ID
     * @return 图书对象
     * @version V1.0
     */
    public ConcreteBook getBook(int ID) {
        ConcreteBook book = null;
        switch (ID) {
            case 1:
                book = new ConcreteBook(ID, "设计模式", "GoF");
                break;
            case 2:
                book = new ConcreteBook(ID, "被遗忘的设计模式", "Null Object Pattern");
                break;
            default:
                book = null;// 其实这个可以省略，因为初始化已经赋值为null。
                break;
        }
        return book;
    }
}
