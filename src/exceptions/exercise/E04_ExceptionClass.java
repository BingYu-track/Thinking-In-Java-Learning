package exceptions.exercise;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/8 20:41
 */
public class E04_ExceptionClass {

    public static void main(String[] args){
        try {
            throw new MyException("MyException message");
        } catch(MyException e) {
            e.printMsg();
        }
        try {
            throw new MyException2("MyException2 message");
        } catch(MyException2 e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }
}
