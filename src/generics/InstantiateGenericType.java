package generics;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/11/25 15:58
 */
public class InstantiateGenericType {

    public static void main(String[] args) {
        ClassAsFactory<Employee> fe = new ClassAsFactory<Employee>(Employee.class);
        print("ClassAsFactory<Employee> succeeded");
        try {
            ClassAsFactory<Integer> fi = new ClassAsFactory<Integer>(Integer.class); //发现Integer创建失败，那是因为Integer没有无参构造器
        } catch(Exception e) {
            print("ClassAsFactory<Integer> failed");
        }
    }
}
