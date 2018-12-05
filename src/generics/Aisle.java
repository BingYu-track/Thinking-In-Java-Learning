package generics;

import java.util.ArrayList;

/**
 * @version 1.0
 * @Description: 过道
 * @author: hxw
 * @date: 2018/10/6 18:58
 */
public class Aisle extends ArrayList<Shelf> { //过道里包含多个货架

    //货架数，商品数量
    public Aisle(int nShelves, int nProducts) {

        for(int i = 0; i < nShelves; i++)
            add(new Shelf(nProducts));
    }
}
