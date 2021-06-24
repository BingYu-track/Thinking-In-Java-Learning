package enumerated;
import java.util.EnumSet;

import static enumerated.AlarmPoints.*;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description: EnumSet
 * @author: bingyu
 * @date: 2021/6/24
 */
public class EnumSets {

    public static void main(String[] args) {
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class); // Empty set 为指定的枚举类型创建一个空的Set
        points.add(BATHROOM);
        print(points);
        points.addAll(EnumSet.of(STAIR1, STAIR2, KITCHEN)); //of方法是创建一个最初包含指定枚举元素的Set集合
        print(points);
        points = EnumSet.allOf(AlarmPoints.class);    //allOf()方法是创建一个最初包含指定枚举类型中所有枚举实例的枚举Set集合
        points.removeAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        print(points);
        //Creates an enum set initially containing all of the elements in the range defined by the two specified endpoints.
        points.removeAll(EnumSet.range(OFFICE1, OFFICE4)); //range()方法是创建一个指定枚举实例范围的Set集合，这里就是创建从OFFICE1到OFFICE4范围的枚举集合
        print(points);
        points = EnumSet.complementOf(points); //complementOf()方法是会先创建一个我们指定相同的enum Set,然后会初始化不包含这个enum Set的所有的枚举Set
        print(points);

        //EnumSet的基础是long,long的其中一位表示enum中的一个实例
    }
}
