package enumerated;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description: 枚举实例重写普通方法
 * @author: bingyu
 * @date: 2021/6/24
 */
public enum OverrideConstantSpecific {
    NUT, BOLT,
    WASHER {
        void f() { print("Overridden method"); }
    };

    void f() { print("default behavior"); } //除了abstract方法外，enum实例还可以覆盖普通方法，这里f()就可以看作是父类的方法

    public static void main(String[] args) {
        for(OverrideConstantSpecific ocs : values()) {
            printnb(ocs + ": ");
            ocs.f();
        }
    }

}
