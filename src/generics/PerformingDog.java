package generics;

import typeinfo.pets.Dog;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/23 19:39
 */
class PerformingDog extends Dog implements Performs{
        public void speak() {
            print("Woof!"); //低吠
        }

        public void sit() {
            print("Sitting"); //坐
        }

        public void reproduce() {

        }
}
