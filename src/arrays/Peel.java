package arrays;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/31 23:10
 */
public class Peel<T> {

    T fruit;
    Peel(T fruit) {
        this.fruit = fruit;
    }

    void peel() {
        System.out.println("Peeling "+ fruit);
    }

}
