package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/24 14:01
 */
public class E03_SixTuple {

    static SixTuple<Vehicle,Amphibian,String,Float,Double,Byte> a() {
        return new SixTuple<Vehicle,Amphibian,String,Float,Double,Byte>(new Vehicle(), new Amphibian(), "hi", (float)4.7, 1.1, (byte)1);
    }

    public static void main(String[] args) {
        System.out.println(a());
    }
}
