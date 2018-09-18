package typeinfo;

import java.lang.reflect.Field;

/**
 * @version 1.0
 * @Description: 反射访问私有域
 * @author: hxw
 * @date: 2018/9/18 22:29
 */
public class ModifyingPrivateFields {

    public static void main(String[] args) throws Exception {
        WithPrivateFinalField pf = new WithPrivateFinalField();
        System.out.println(pf);
        Field f = pf.getClass().getDeclaredField("i"); //根据字段名获取字段
        f.setAccessible(true);
        System.out.println("f.getInt(pf): " + f.getInt(pf));
        f.setInt(pf, 47); //设置pf属性值为47
        System.out.println(pf);
        f = pf.getClass().getDeclaredField("s");
        f.setAccessible(true);
        System.out.println("f.get(pf): " + f.get(pf));
        f.set(pf, "No, you’re not!");
        System.out.println(pf);
        f = pf.getClass().getDeclaredField("s2");
        f.setAccessible(true);
        System.out.println("f.get(pf): " + f.get(pf));
        f.set(pf, "No, you’re not!");
        System.out.println(pf);
    }
}
