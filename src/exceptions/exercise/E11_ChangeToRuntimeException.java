package exceptions.exercise;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/15 23:56
 */
public class E11_ChangeToRuntimeException {

    public void g() throws AnException2 {
        throw new AnException2();
    }
    public void f() {
        try {
            g();
        } catch(AnException2 e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args){
        E11_ChangeToRuntimeException ce = new E11_ChangeToRuntimeException();
        ce.f();
    }
}
