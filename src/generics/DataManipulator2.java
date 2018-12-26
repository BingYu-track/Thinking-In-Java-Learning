package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/26 22:57
 */
final class DataManipulator2 {

    private String value;
    public DataManipulator2(String value) {
        setValue(value);
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
