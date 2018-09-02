package typeinfo.pets;

import java.util.HashMap;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/29 23:13
 */
public class PetCount {

    //静态内部类，继承了HashMap
    static class PetCounter extends HashMap<String,Integer> {
        public void count(String type) {
            Integer quantity = get(type);
            if(quantity == null){
                put(type, 1);
            } else{
                put(type, quantity + 1); //存在key,其值增加1
            }
        }
    }

    public static void countPets(PetCreator creator) {
        PetCounter counter = new PetCounter(); //创建了静态内部类对象--宠物计数器
        for (Pet pet : creator.createArray(20)) {
            // List each individual pet:
            printnb(pet.getClass().getSimpleName() + " ");
            if (pet instanceof Pet)
                counter.count("Pet");
            if (pet instanceof Dog)
                counter.count("Dog");
            if (pet instanceof Mutt)
                counter.count("Mutt");
            if (pet instanceof Pug)
                counter.count("Pug");
            if (pet instanceof Cat)
                counter.count("Cat");
            if (pet instanceof Manx)
                counter.count("EgyptianMau");
            if (pet instanceof Manx)
                counter.count("Manx");
            if (pet instanceof Manx)
                counter.count("Cymric");
            if (pet instanceof Rodent)
                counter.count("Rodent");
            if (pet instanceof Rat)
                counter.count("Rat");
            if (pet instanceof Mouse)
                counter.count("Mouse");
            if (pet instanceof Hamster)
                counter.count("Hamster");
        }
        // Show the counts:
        print();
        print(counter);
    }

    public static void main(String[] args) {
        countPets(new ForNameCreator()); //在创建ForNameCreator对象时,所有Pet对象已经创建完毕
    }

}
