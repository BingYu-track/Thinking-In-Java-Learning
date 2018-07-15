package exceptions.exercise;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/15 23:50
 */
public class E10_ChangeException {

    public void f() throws AnotherException {
        try {
            g();
        } catch (AnException e) {
            e.printStackTrace();
            throw new AnotherException();
        }
    }

    public void g() throws AnException {
        throw new AnException();
    }
    
    public static void main(String[] args){
        E10_ChangeException ce = new E10_ChangeException();
        try {
            ce.f();
        } catch (AnotherException e) {
            System.out.println("Caught " + e);
        }
    }
}
