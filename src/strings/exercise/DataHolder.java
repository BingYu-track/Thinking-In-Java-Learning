package strings.exercise;

import java.util.Locale;

import static java.lang.String.format;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/7 21:53
 */
class DataHolder {
    int intField = 1;
    long longField = 2L;
    float floatField = 3.0f;
    double doubleField = 4.0;
    public String toString() {
        StringBuilder result = new StringBuilder("DataHolder: \n");
        //format(Locale l, String format, Object... args) Locale表示使用指定的语言环境，这里作者指定的是US
        //1.为什么静态方法可以省略类名?
        //答：只需要在引用类的时候加个import static java.lang.String.format; 就可以直接用了
        result.append(format(Locale.US, "intField: %d\n", intField));
        result.append(format(Locale.US, "longField: %d\n", longField));
        result.append(format(Locale.US, "floatField: %f\n", floatField));
        result.append(format(Locale.US, "doubleField: %e\n", doubleField));
        return result.toString();
    }
}
