package generics;

import java.util.ArrayList;

/**
 * @version 1.0
 * @Description: 商店
 * @author: hxw
 * @date: 2018/10/6 19:00
 */
public class Store extends ArrayList<Aisle> { //一个商店有多个过道

    private ArrayList<CheckoutStand> checkouts = new ArrayList<CheckoutStand>();

    private Office office = new Office();

    public Store(int nAisles, int nShelves, int nProducts) {
        for(int i = 0; i < nAisles; i++)
        add(new Aisle(nShelves, nProducts));
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for(Aisle a : this)
            for(Shelf s : a)
                for(Product p : s) {
                    result.append(p); //这里代码很好的诠释了，在循环中操作字符串使用StringBuilder效率是最好的
                    result.append("\n");
                }
        return result.toString();
    }

    public static void main(String[] args) {
        //创建一个拥有14个过道，每个过道有5个货架，每个货架有10个商品的商店
        System.out.println(new Store(14, 5, 10));
    }
}
