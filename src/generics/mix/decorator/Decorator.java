package generics.mix.decorator;

/**
 * @Description:
 * @author: hxw
 * @version 1.0
 * @date: 2018/12/17 20:09
 */
class Decorator extends Basic{

    protected Basic basic;
    public Decorator(Basic basic) { //有参构造
        this.basic = basic;
    }

    public void set(String val) {
        basic.set(val);
    }

    public String get() {
        return basic.get();
    }

}
