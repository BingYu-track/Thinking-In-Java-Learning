package typeinfo.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/27 20:51
 */
public class E06_Highlight {

    public static void main(String[] args) {
        List<HShape> shapes = Arrays.asList(
                new HCircle(), new HSquare(),
                new HTriangle(), new HSquare(),
                new HTriangle(), new HCircle(),
                new HCircle(), new HSquare()
        );
        HShape.highlight1(HCircle.class); //只将HCircle类型的对象进行标识
        HShape.highlight2(HCircle.class); //同样是将HCircle类型的对象进行标识，但内部使用了反射
        for(HShape shape : shapes){
            shape.draw();
        }
        System.out.println("*******");

        // Highlight them all: 将他们所有标识
        HShape.highlight1(HShape.class);
        HShape.highlight2(HShape.class);
        for(HShape shape : shapes){
            shape.draw();
        }
        System.out.println("*******");

        // Not in the hierarchy:不进行标识
        HShape.clearHighlight1(ArrayList.class);
        HShape.clearHighlight2(ArrayList.class);
        for(HShape shape : shapes){
            shape.draw();
        }
    }
}
