package containers;

import net.mindview.util.Countries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @version 1.0
 * @Description: Enumeration就相当于我们现在的Iterator迭代器
 * @author: hxw
 * @date: 2019/2/10 16:53
 */
public class Enumerations {

    public static void main(String[] args) {
        Vector<String> v = new Vector<String>(Countries.names(10));
        Enumeration<String> e = v.elements();
        while(e.hasMoreElements()){
            System.out.print(e.nextElement() + ", ");
        }
            // Produce an Enumeration from a Collection:
        e = Collections.enumeration(new ArrayList<String>());
    }
}
