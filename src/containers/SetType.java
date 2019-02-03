package containers;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/3 11:13
 */
public class SetType {

    int i;
    public SetType(int n) {
        i = n;
    }

    public boolean equals(Object o) {
        //对象是SetType类型并且i值相同
        return o instanceof SetType && (i == ((SetType)o).i);
    }

    //打印i值
    public String toString() {
        return Integer.toString(i);
    }

}
