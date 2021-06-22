package enumerated;
// No values() method if you upcast an enum
enum Search { HITHER, YON }
/**
 * @version 1.0
 * @Description:
 * @author: bingyu
 * @date: 2021/6/22
 */
public class UpcastEnum {

    public static void main(String[] args) {
        Search[] vals = Search.values();
        Enum e = Search.HITHER; // Upcast 向上转成Enum，此时无法再使用values()方法,但是可以使用e.getClass().getEnumConstants()获取所有的Enum实例
        // e.values(); // No values() in Enum
        for(Enum en : e.getClass().getEnumConstants()) {
            System.out.println(en);
        }
    }
}
