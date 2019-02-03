package containers;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/3 11:14
 */
public class HashType extends SetType{ //对比SetType，多重写了hashCode方法

    public HashType(int n) {
        super(n);
    }

    public int hashCode() {
        return i;
    }

}
