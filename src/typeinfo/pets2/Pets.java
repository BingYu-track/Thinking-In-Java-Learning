package typeinfo.pets2;

import typeinfo.factory.Factory;
import typeinfo.pets.Pet;
import typeinfo.pets.PetCreator;

import java.util.*;
import typeinfo.factory.Factory;
import typeinfo.pets.PetCreator;
import typeinfo.pets.Pet;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/5 12:51
 */
@SuppressWarnings("unchecked")
public class Pets {

    private static Random rand = new Random(47);
    public static final PetCreator creator = new RFPetCreator();

    //静态内部类RFPetCreator
    private static class RFPetCreator extends PetCreator {
        static List<Factory<? extends Pet>> petFactories = Arrays.asList(
                        new Mutt.Factory(), new Pug.Factory(),
                        new EgyptianMau.Factory(), new Manx.Factory(),
                        new Cymric.Factory(), new Rat.Factory(),
                        new Mouse.Factory(), new Hamster.Factory()
        );

        @Override
        public List<Class<? extends Pet>> types() {
            return null; // Dummy value, this method is not used!
        }

        @Override
        public Pet randomPet() { // Make 1 random Pet
            int n = rand.nextInt(petFactories.size());
            return petFactories.get(n).create();
        }
    }


    public static Pet randomPet() {
        return creator.randomPet();
    }
    public static Pet[] createArray(int size) {
        return creator.createArray(size);
    }
    public static ArrayList<Pet> arrayList(int size) {
        return creator.arrayList(size);
    }
}