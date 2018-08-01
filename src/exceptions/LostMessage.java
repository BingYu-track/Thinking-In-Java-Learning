package exceptions;

import innerclasses.A;

/**
 * @version 1.0
 * @Description: 目前Java异常的缺陷
 * @author: hxw
 * @date: 2018/7/17 22:21
 */
public class LostMessage {
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }
    void dispose() throws HoHumException {
        throw new HoHumException();
    }
    public static void main(String[] args) {
        try {
            LostMessage lm = new LostMessage();
           try {
                lm.f();
            } finally {
                lm.dispose(); //这样特殊使用finally子句,f()方法中抛出的异常之前又抛出了另一个异常会丢失之前的异常信息
            }
        } catch(Exception e) {
            System.out.println(e); //A trivial exception
        }
    }
    //从输出看到VeryImportantException不见了，它被finally语句中的HoHumException所取代(目前解决方案见 GuardedLostMessage.java)
}
