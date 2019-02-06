package containers;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/6 18:51
 */
public class Groundhog2 extends Groundhog {

    public Groundhog2(int n) {
        super(n);
    }

    public int hashCode() {
        return number;
    }

    public boolean equals(Object o) {
        return o instanceof Groundhog2 && (number == ((Groundhog2)o).number); //这里instanceof不仅仅是验证对象是否是Groundhog2类型，还悄悄检查了对象是否为null,
        //因为instanceof null会直接返回false
    }
}
