package holding;

import typeinfo.pets.*;
import java.util.*;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/4 8:10
 */
public class NonCollectionSequence extends PetSequence {

    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int index = 0;
            public boolean hasNext() {
                return index < pets.length;
            }
            public Pet next() { return pets[index++]; }
            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        NonCollectionSequence nc = new NonCollectionSequence();
        InterfaceVsIterator.display(nc.iterator());
    }
}
