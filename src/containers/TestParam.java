package containers;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/8 3:16
 */
public class TestParam {

    public final int size; //容器中元素的数量
    public final int loops; //测试的迭代次数
    public TestParam(int size, int loops) {
        this.size = size;
        this.loops = loops;
    }

    // Create an array of TestParam from a varargs sequence: 从可变参序列创建TestParam数组：
    public static TestParam[] array(int... values) {
        int size = values.length/2; //可变参长度取半
        TestParam[] result = new TestParam[size];
        int n = 0;
        for(int i = 0; i < size; i++){
            result[i] = new TestParam(values[n++], values[n++]);
        }
        return result;
    }

    // Convert a String array to a TestParam array:
    public static TestParam[] array(String[] values) {
        int[] vals = new int[values.length];
        for(int i = 0; i < vals.length; i++){
            vals[i] = Integer.decode(values[i]); //将 String 解码为 Integer
        }
        return array(vals);
    }

}
