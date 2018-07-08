package exceptions;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/8 21:47
 */
class MyException2 extends Exception{

    private int x;
    public MyException2() {}
    public MyException2(String msg) { super(msg); }
    public MyException2(String msg, int x) {
        super(msg);
        this.x = x;
    }
    public int val() { return x; }

    //覆盖Throwable.getMessage()方法
    public String getMessage() {
        return "Detail Message: "+ x + " "+ super.getMessage();
    }
}
