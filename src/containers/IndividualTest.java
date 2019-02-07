package containers;

import holding.MapOfList;
import typeinfo.pets.Individual;
import typeinfo.pets.Pet;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/8 2:32
 */
public class IndividualTest {

    public static void main(String[] args) {
        Set<Individual> pets = new TreeSet<Individual>();
        for(List<? extends Pet> lp : MapOfList.petPeople.values()){
            for(Pet p : lp)
                pets.add(p);
        }
        System.out.println(pets);
    }
}
