package typeinfo.testnullpattern;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/10 21:33
 */
public class ConcreteBook {
    private int ID;
    private String name;
    private String author;

    // 构造函数
    public ConcreteBook(int ID, String name, String author) {
        this.ID = ID;
        this.name = name;
        this.author = author;
    }

    /**
     *
     * Description About show: <br>
     * 展示图书的相关信息
     * @version V1.0
     */
    public void show() {
        System.out.println(ID + "**" + name + "**" + author);
    }

}
