package generics.mix.decorator;

/**
 * @Description:
 * @author: hxw
 * @version 1.0
 * @date: 2018/12/17 21:21
 */
class BasicCoffee {

    private String type;
    public BasicCoffee() {}
    public BasicCoffee(String type) {
        setType(type);
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
