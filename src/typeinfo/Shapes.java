package typeinfo;

import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/26 20:37
 */
public class Shapes {

    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(
                new Circle(), new Square(), new Triangle()
        );
        for(Shape shape : shapeList){
            shape.draw(); //这里draw()使用了this关键字，导致间接调用了toString方法
        }
    }
}
