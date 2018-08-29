package typeinfo;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/29 22:05
 */
public class ClassCasts {

    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseType = House.class;
        House h = houseType.cast(b); //cast(Object obj)将一个对象强制转换成此 Class 对象所表示的类，与下面的做法等效
        h = (House)b; // ... or just do this.
    }
}
