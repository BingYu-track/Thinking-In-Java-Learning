package typeinfo.exercise;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/27 20:41
 */
class HShape {

    //标识
    boolean highlighted = false;
    static List<HShape> shapes = new ArrayList<HShape>();

    public void highlight() {
        highlighted = true;
    }

    public void clearHighlight() {
        highlighted = false;
    }

    void draw() {
        System.out.println(this + " draw()");
    }

    public String toString() {
        return getClass().getName() + (highlighted ? " highlighted" : " normal"); //获取全限定类名
    }


    HShape() {
        shapes.add(this); //将自身加入集合
    }
    // Basic approach (code duplication)
    static void highlight1(Class<?> type) {
        for(HShape shape : shapes){ //注意这里的shapes集合内容不是main方法中的shapes集合
            if(type.isInstance(shape)){ //判断shape对象是不是type的实例，等效于 shape instanceof 类型
                shape.highlight();
            }
        }
    }

    //清除标识
    static void clearHighlight1(Class<?> type) {
        for(HShape shape : shapes){
            if(type.isInstance(shape)){
                shape.clearHighlight();
            }
        }
    }
    // Create an applicator and reuse it. All exceptions indicate programmer error, and are thus RuntimeExceptions:
    static void forEach(Class<?> type, String method) {
        try {
            Method m = HShape.class.getMethod(method, (Class<?>[])null);
            for(HShape shape : shapes){
                if(type.isInstance(shape)){
                    m.invoke(shape, (Object[])null); //通过反射执行highlight方法
                }
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    static void highlight2(Class<?> type) {
        forEach(type, "highlight");
    }
    static void clearHighlight2(Class<?> type) {
        forEach(type, "clearHighlight");
    }
}
