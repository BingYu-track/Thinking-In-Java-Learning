package exceptions.exercise;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/8 20:38
 */
class MyException extends Exception{

    String msg;
    public MyException(String msg) {
        this.msg = msg;
    }
    public void printMsg() {
        System.out.println("msg = " + msg);
    }
}
