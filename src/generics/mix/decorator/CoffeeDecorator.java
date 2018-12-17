package generics.mix.decorator;

/**
 * @Description:
 * @author: hxw
 * @version 1.0
 * @date: 2018/12/17 21:22
 */
class CoffeeDecorator extends BasicCoffee{
    protected BasicCoffee basic;
    public CoffeeDecorator(BasicCoffee basic) {
        this.basic = basic;
    }
    public void setType(String type) {
        basic.setType(type);
    }

    public String getType() {
        return basic.getType();
    }

}
