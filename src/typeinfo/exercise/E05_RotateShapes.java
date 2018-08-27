package typeinfo.exercise;

import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/27 8:44
 */
public class E05_RotateShapes {

    static void rotateAll(List<RShape> shapes) {
        for(RShape shape : shapes){
            if(!(shape instanceof RCircle)){
                shape.rotate(45);
            }
        }
    }
    public static void main(String[] args) {
        List<RShape> shapes = Arrays.asList(
                new RCircle(), new RSquare(), new RTriangle()
        );
        rotateAll(shapes);
    }
}
