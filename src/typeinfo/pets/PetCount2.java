package typeinfo.pets;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/3 21:12
 */
public class PetCount2 {
    public static void main(String[] args) {
        PetCreator creator = Pets.creator;
        Pet[] array = creator.createArray(20);
        System.out.println(array);
        PetCount.countPets(creator);
    }
}
