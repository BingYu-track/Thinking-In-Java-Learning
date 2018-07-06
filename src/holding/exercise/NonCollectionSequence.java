package holding.exercise;

import holding.PetSequence;
import typeinfo.pets.Pet;

import java.util.*;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/6 8:08
 */
public class NonCollectionSequence extends PetSequence implements Iterable<Pet> {

    //实现iterator方法，能使用foreach正常向后遍历
    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int firstIndex = 0;

            @Override
            public boolean hasNext() {
                return firstIndex < pets.length;
            }

            @Override
            public Pet next() {
                return pets[firstIndex++];
            }

            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }

    //新增一个产生Iterable的方法，使当前对象能进行反向foreach
    public Iterable<Pet> reversed(){
        return new Iterable<Pet>() {
            @Override
            public Iterator<Pet> iterator() {
                return new Iterator<Pet>() {
                    int lastIndex = pets.length-1;

                    @Override
                    public boolean hasNext() {
                        return lastIndex > -1;
                    }

                    @Override
                    public Pet next() {
                        return pets[lastIndex--];
                    }

                    public void remove() { // Not implemented
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    public Iterable<Pet> randomized(){
        return new Iterable<Pet>() {
            @Override
            public Iterator<Pet> iterator() {
                List<Pet> shuffled = new ArrayList<Pet>(Arrays.asList(pets));
                Collections.shuffle(shuffled , new Random(47));
                return shuffled.iterator();
            }
        };
    }
}
