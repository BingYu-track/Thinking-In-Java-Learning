package arrays;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/1/13 22:53
 */
public class DataHolderWithEquals extends DataHolder{

    DataHolderWithEquals(int data) { super(data); }

    public boolean equals(Object o) {
        return o instanceof DataHolderWithEquals && data == ((DataHolder)o).data;
    }
}
