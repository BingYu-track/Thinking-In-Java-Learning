package enumerated;

import static net.mindview.util.Print.*;

enum Shrubbery { GROUND, CRAWLING, HANGING } //居然还可以这样写
/**
 * @version 1.0
 * @Description:
 * @author: bingyu
 * @date: 2021/6/21
 */
public class EnumClass {

    public static void main(String[] args) {
        for(Shrubbery s : Shrubbery.values()) {
            print(s + " ordinal: " + s.ordinal()); //ordinal()方法返回一个int值，这是每个enum实例在声明时的次序，从0开始的
            printnb(s.compareTo(Shrubbery.CRAWLING) + " "); //Enum实现了Comparable接口，可以直接比较
            printnb(s.equals(Shrubbery.CRAWLING) + " ");
            print(s == Shrubbery.CRAWLING);
            print(s.getDeclaringClass()); //enum实例的getDeclaringClass()方法，返回给实例所属的enum类
            print(s.name());  //返回enum实例声明时的名字
            print("----------------------");
        }
    // Produce an enum value from a string name:
        for(String s : "HANGING CRAWLING GROUND".split(" ")) {
            Shrubbery shrub = Enum.valueOf(Shrubbery.class, s); //Enum.valueOf()方法是根据名字返回相应的enum实例
            print(shrub);
        }
    }
}
