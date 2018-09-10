package typeinfo.testnullpattern;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/10 21:43
 */
public class NullBook implements Book {


    @Override
    public boolean isNull() {
        return true;
    }

    @Override
    public void show() {
        System.out.println("Sorry，未找到符合您输入的ID的图书信息，请确认您输入的不是非法值。");
    }
}
