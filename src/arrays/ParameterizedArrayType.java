package arrays;

import com.dw.thinkinginjava.initilization.Banana;

/**
 * @version 1.0
 * @Description: 泛型与数组--虽然不能创建具有参数类型的数组，但是可以参数化数组本身的类型
 * @author: hxw
 * @date: 2018/12/31 22:20
 */
public class ParameterizedArrayType {

    public static void main(String[] args) {
        Integer[] ints = { 1, 2, 3, 4, 5 };
        Double[] doubles = { 1.1, 2.2, 3.3, 4.4, 5.5 };
        Integer[] ints2 = new ClassParameter<Integer>().f(ints);
        Double[] doubles2 = new ClassParameter<Double>().f(doubles);
        ints2 = MethodParameter.f(ints);
        doubles2 = MethodParameter.f(doubles);
    }
}
