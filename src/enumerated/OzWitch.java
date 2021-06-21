package enumerated;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description:
 * @author: bingyu
 * @date: 2021/6/21
 */
public enum OzWitch {
    // Instances must be defined first, before methods: 声明实例必须在最前面，如果后面有方法，必须以分号结尾
    WEST("Miss Gulch, aka the Wicked Witch of the West"),
    NORTH("Glinda, the Good Witch of the North"),
    EAST("Wicked Witch of the East, wearer of the Ruby " +
            "Slippers, crushed by Dorothy’s house"),
    SOUTH("Good by inference, but missing");

    private String description;
    // Constructor must be package or private access: 枚举的构造函数只能是private访问权限
    private OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for(OzWitch witch : OzWitch.values())
            print(witch + ": " + witch.getDescription());
    }
}
