package generics;

import net.mindview.util.New;
import typeinfo.pets.*;
import net.mindview.util.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/10/4 21:05
 */
public class SimplerPets {

    public static void main(String[] args) {
        //普通写法：Map<Person, List<? extends Pet>> petPeople = new HashMap<Person, List<? extends Pet>>();
        Map<Person, List<? extends Pet>> petPeople = New.map(); //调用New工具类,New中利用的就是类型推断
        // Rest of the code is the same...
    }
}
