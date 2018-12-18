package generics.mix.decorator;

/**
 * @Description: 泡沫咖啡
 * @author: hxw
 * @version 1.0
 * @date: 2018/12/17 21:24
 */
class Foam extends CoffeeDecorator{
    public Foam(BasicCoffee basic) {
        super(basic);
        setType(getType() + " & foam");
    }
}
