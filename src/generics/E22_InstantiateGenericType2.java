package generics;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/11/25 17:22
 */
public class E22_InstantiateGenericType2 {

    public static void main(String[] args){
        ClassAsFactory2<Employee> fe = new ClassAsFactory2<Employee>(Employee.class);
        Employee emp = fe.create(1);
        if(emp == null)
            print("Employee cannot be instantiated!");
        ClassAsFactory2<Integer> fi = new ClassAsFactory2<Integer>(Integer.class);
        Integer i = fi.create(0);
        if(i == null)
            print("Integer cannot be instantiated!");
    }
}
