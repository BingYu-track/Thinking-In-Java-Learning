package holding;

import java.util.Map;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/4 12:34
 */
public class EnvironmentVariables {

    public static void main(String[] args) {
        for(Map.Entry entry: System.getenv().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
