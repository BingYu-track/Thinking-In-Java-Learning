package holding.exercise;

import typeinfo.pets.Person;

import java.util.HashMap;
import java.util.Iterator;
import java.util.*;
import java.util.Map.Entry;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/6/24 23:05
 */
public class E17_PersonMap {

    public static void main(String args[]) {
        Map<String,Person> map = new HashMap<String,Person>();
        map.put("Fuzzy", new Person("a"));
        map.put("Spot", new Person("b"));
        map.put("Joe", new Person("c"));
        map.put("Ted", new Person("d"));
        map.put("Heather", new Person("e"));
        Iterator<Entry<String, Person>> it =  map.entrySet().iterator(); //获取映射关系的Set集合再进行遍历
        while(it.hasNext()) {
            Entry<String, Person> entry = it.next();
            System.out.print(entry.getKey() + ": ");
            System.out.println(entry.getValue().toString());
        }
    }
}
