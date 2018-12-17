package generics.mix.decorator;

/**
 * @Description:
 * @author: hxw
 * @version 1.0
 * @date: 2018/12/17 20:12
 */
class SerialNumbered extends Decorator{
    private static long counter = 1;
    private final long serialNumber = counter++;
    public SerialNumbered(Basic basic) {
        super(basic);
    }

    public long getSerialNumber() {
        return serialNumber;
    }

}
