package containers;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/1/17 0:08
 */
public class StringAddress {
    private String s;
    public StringAddress(String s) { this.s = s; }
    public String toString() {
        return super.toString() + " " + s;
    }
}
