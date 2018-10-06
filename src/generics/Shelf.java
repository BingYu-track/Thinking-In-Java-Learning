package generics;

import java.util.ArrayList;

/**
 * @version 1.0
 * @Description: 货架
 * @author: hxw
 * @date: 2018/10/6 18:58
 */
class Shelf extends ArrayList<Product> { //一个货架拥有多个商品

    //构造器输入商品数量
    public Shelf(int nProducts) {
        //把货架填充商品
        Generators.fill(this, Product.generator, nProducts);//巧妙
    }
}
