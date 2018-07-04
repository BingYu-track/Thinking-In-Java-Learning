package holding.exercise;

import polymorphism.shape.Shape;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/4 12:51
 */
public class E31_IterableRandomShapeGenerator {

    public static void main(String[] args) {
        RandomShapeGenerator rsg = new RandomShapeGenerator(10);
        for(Shape shape : rsg)
            System.out.println(shape.getClass().getSimpleName());
    }
}
