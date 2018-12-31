package arrays;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/31 23:09
 */
class Banana {
    private final int id;
    Banana(int id) {
        this.id = id;
    }

    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
