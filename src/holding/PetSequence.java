package holding;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

import java.util.Arrays;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/4 8:12
 */
public class PetSequence {
    protected Pet[] pets = Pets.createArray(8);

    public Pet[] getPets() {
        return pets;
    }

    public void setPets(Pet[] pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "PetSequence{" +
                "pets=" + Arrays.toString(pets) +
                '}';
    }
}
