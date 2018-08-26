package typeinfo.toys;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/26 22:17
 */
class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots{
    FancyToy() { super(1); }
}
