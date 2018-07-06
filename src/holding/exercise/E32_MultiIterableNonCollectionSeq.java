package holding.exercise;

import typeinfo.pets.Pet;

import java.util.Arrays;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/6 8:26
 */
public class E32_MultiIterableNonCollectionSeq {

    public static void main(String[] args) {
        NonCollectionSequence nc = new NonCollectionSequence ();
        for (Pet pet : nc.reversed()) {
            System.out.print(pet + " ");
        }
        System.out.println();
        for(Pet pet : nc.randomized()){
            System.out.print(pet + " ");
        }
        System.out.println();
        for(Pet pet : nc)
            System.out.print(pet + " ");
    }
}
