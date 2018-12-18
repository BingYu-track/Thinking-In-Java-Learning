package generics.mix.decorator;

/**
 * @Description: 焦糖咖啡
 * @author: hxw
 * @version 1.0
 * @date: 2018/12/17 21:26
 */
class Caramel extends CoffeeDecorator{
    public Caramel(BasicCoffee basic) {
        super(basic);
        setType(getType() + " & caramel");
    }
}
