package generics;

import static net.mindview.util.Print.*;
import java.util.ArrayList;
import java.util.List;
import typeinfo.pets.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/24 21:54
 */
public class E41_Fill3 {
    public static void main(String[] args) throws Exception {
        // Adapt a Collection:
        List<Pet> carrier = new ArrayList<Pet>();
        Fill2.fill(new AddableCollectionAdapter<Pet>(carrier), Pet.class, 3);
        // Helper method captures the type:
        Fill2.fill(Adapter.collectionAdapter(carrier), Mouse.class, 2);
        for(Pet p: carrier){
            print(p);
        }

        print("----------------------");
        // Use an adapted class:
        AddableSimpleQueue<Pet> petQueue = new AddableSimpleQueue<Pet>();
        Fill2.fill(petQueue, Mutt.class, 4);
        Fill2.fill(petQueue, Cymric.class, 1);
        for(Pet p: petQueue)
            print(p);
    }
}
