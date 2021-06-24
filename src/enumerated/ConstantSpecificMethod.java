package enumerated;
import java.text.*;
import java.util.Date;

/**
 * @version 1.0
 * @Description: 编写Enum中的常量实例方法
 * @author: bingyu
 * @date: 2021/6/24
 */
public enum ConstantSpecificMethod {
    DATE_TIME {
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },
    CLASSPATH {
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },
    VERSION {
        String getInfo() {
            return System.getProperty("java.version");
        }
    };

    //枚举实例常量必须放在最前面，否则就会报错
    //要想为每个enum实例编写方法，就需要在Enum类中定义一个abstract方法，一旦在Enum类里面定义了，所有枚举实例必须实现它
    abstract String getInfo();

    public static void main(String[] args) {
        for(ConstantSpecificMethod csm : values()) {
            System.out.println(csm.getInfo());
        }
    }

}
