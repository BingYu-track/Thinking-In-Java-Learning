package typeinfo.toys;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/29 21:51
 */
public class GenericToyTest {

    public static void main(String[] args) throws Exception {
        Class<FancyToy> ftClass = FancyToy.class;
        // Produces exact type:
        FancyToy fancyToy = ftClass.newInstance();
        Class<? super FancyToy> up = ftClass.getSuperclass(); //获得FancyToy父类的Class
        // 下面这样做是无法通过编译的:
        // Class<Toy> up2 = ftClass.getSuperclass();
        // Only produces Object:
        Object obj = up.newInstance();
    }
}
