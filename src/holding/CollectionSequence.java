package holding;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

import java.util.*;

/**
 * @version 1.0
 * @Description: 如果实现Collection需要实现许多方法，这里如果可以继承AbstractCollection就省略了很多
 * @author: hxw
 * @date: 2018/7/4 7:44
 */
public class CollectionSequence extends AbstractCollection<Pet> {

    private Pet[] pets = Pets.createArray(8);

    @Override
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

    @Override
    public int size() {
        return pets.length;
    }

    public static void main(String[] args) {
        CollectionSequence c = new CollectionSequence();
        InterfaceVsIterator.display(c);
        InterfaceVsIterator.display(c.iterator());
    }
}
