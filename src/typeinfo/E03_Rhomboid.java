package typeinfo;

import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/27 8:28
 */
public class E03_Rhomboid {

    public static void main(String[] args) {
        List<Shape> shapes = Arrays.asList(
                new Circle(), new Square(), new Triangle(),
                new Rhomboid()
        );
        for(Shape shape : shapes)
            shape.draw();
        // 向上转型为shape:
        Shape shape = new Rhomboid();
        // 向下转型为Rhomboid:
        Rhomboid r = (Rhomboid)shape;
        // 向下转型为Circle. 编译时成功,但运行时出现ClassCastException:
        //! Circle c = (Circle)shape;
    }
}
