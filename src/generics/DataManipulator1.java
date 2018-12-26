package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/26 22:56
 */
final class DataManipulator1 implements Comparable<DataManipulator1>{

    private int value;
    public DataManipulator1(int value) {
        this.value = value;
    }

    public void increment() {
        ++value;
    }

    public int getValue() {
        return value;
    }

    public int compareTo(DataManipulator1 other) {
        return Integer.valueOf(value).compareTo(other.value);
    }
    public String toString() {
        return Integer.toString(value);
    }
}
