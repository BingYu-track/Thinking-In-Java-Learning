package generics.mix.decorator;

/**
 * @Description:
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
