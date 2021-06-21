package enumerated;
import static enumerated.Spiciness.*; //使用import static将enum实例的声明符带入当前的命名空间
/**
 * @version 1.0
 * @Description:  静态导入import static在enum中的使用
 * @author: bingyu
 * @date: 2021/6/21
 */
public class Burrito {

    Spiciness degree;
    public Burrito(Spiciness degree) { this.degree = degree;}
    public String toString() { return "Burrito is "+ degree;}
    public static void main(String[] args) {
        System.out.println(new Burrito(NOT));
        System.out.println(new Burrito(MEDIUM));
        System.out.println(new Burrito(HOT));
    }
}
