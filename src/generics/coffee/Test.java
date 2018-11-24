package generics.coffee;

import net.mindview.util.Generator;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/11/24 22:06
 */
public class Test implements Generator<Coffee> {
    @Override
    public Coffee next() {
        Test test = new Test();
        //对泛型使用instanceof操作，编译器报错
        /*if(test instanceof Generator<Coffee>){

        }*/
        return null;
    }
}
