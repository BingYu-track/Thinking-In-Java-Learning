package enumerated;

/**
 * @version 1.0
 * @Description: 甚至可以对不是枚举的类调用getEnumConstants()方法
 * @author: bingyu
 * @date: 2021/6/22
 */
public class NonEnum {
    public static void main(String[] args) {
        Class<Integer> intClass = Integer.class;
        try {
            for(Object en : intClass.getEnumConstants()) {
                System.out.println(en);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
