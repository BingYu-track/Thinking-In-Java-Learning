package generics.mix.decorator;

/**
 * @Description: 奶油咖啡
 * @author: hxw
 * @version 1.0
 * @date: 2018/12/17 21:27
 */
class WhippedCream extends CoffeeDecorator{
    public WhippedCream(BasicCoffee basic) {
        super(basic);
        setType(getType() + " & whipped cream");
    }
}
