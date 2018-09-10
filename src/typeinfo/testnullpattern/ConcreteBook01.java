package typeinfo.testnullpattern;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/10 21:44
 */
public class ConcreteBook01 implements Book {

    private int ID;
    private String name;
    private String author;

    // 构造函数
    public ConcreteBook01(int ID, String name, String author) {
        this.ID = ID;
        this.name = name;
        this.author = author;
    }

    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public void show() {
        System.out.println(ID + "**" + name + "**" + author);
    }
}
