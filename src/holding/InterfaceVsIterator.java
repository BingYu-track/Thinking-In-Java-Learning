package holding;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

import java.util.*;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/4 7:59
 */
public class InterfaceVsIterator {

    public static void display(Iterator<Pet> it) {
        while(it.hasNext()) {
            Pet p = it.next();
            System.out.print(p.id() + ":" + p + " ");
        }
        System.out.println();
    }
    public static void display(Collection<Pet> pets) {
        for(Pet p : pets){  //实际调用的仍是iterator方法
            System.out.print(p.id() + ":" + p + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        List<Pet> petList = Pets.arrayList(8);
        Set<Pet> petSet = new HashSet<Pet>(petList);
        Map<String,Pet> petMap = new LinkedHashMap<String,Pet>();
        String[] names = ("Ralph, Eric, Robin, Lacey, " + "Britney, Sam, Spot, Fluffy").split(", ");
        for(int i = 0; i < names.length; i++){
            petMap.put(names[i], petList.get(i));
        }
        display(petList);
        display(petSet);
        display(petList.iterator());
        display(petSet.iterator());
        System.out.println(petMap);
        System.out.println(petMap.keySet());
        display(petMap.values());
        display(petMap.values().iterator());
    }
}
