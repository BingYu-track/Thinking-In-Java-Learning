package generics;

/**
 * @version 1.0
 * @Description: 一个类不能同时实现一个泛型接口的两种变体
 * @author: hxw
 * @date: 2018/12/11 0:35
 */
public class MultipleInterfaceVariants {
    interface Payable<T> {}

    /*class Employee implements Payable<Employee>{}
    class Hourly extends Employee implements Payable<Hourly> { }*/

    /*
    无法编译，因为擦除会将Payable<Employee>和Payable<Hourly>简化为相同的类Payable，这就相当于Hourly实现了两个相同的接口Payable，但是
    如果你将Payable<Employee>和Payable<Hourly>中的泛型去掉，却能编译通过！
    */

    class Employee implements Payable{}

    class Hourly extends Employee implements Payable { }
}
