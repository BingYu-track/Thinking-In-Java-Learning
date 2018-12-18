package generics.mix.decorator;

/**
 * @Description: 牛奶咖啡
 * @author: hxw
 * @version 1.0
 * @date: 2018/12/17 21:23
 */
class SteamedMilk extends CoffeeDecorator{

    public SteamedMilk(BasicCoffee basic) {
        super(basic);
        setType(getType() + " & steamed milk");
    }
}
