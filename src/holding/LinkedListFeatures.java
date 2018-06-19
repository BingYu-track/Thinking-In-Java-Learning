package holding;

import typeinfo.pets.Hamster;
import typeinfo.pets.Pet;
import typeinfo.pets.Pets;
import typeinfo.pets.Rat;

import java.util.LinkedList;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/6/19 16:46
 */
public class LinkedListFeatures {

    public static void main(String[] args) {
        LinkedList<Pet> pets = new LinkedList<Pet>(Pets.arrayList(5));
        System.out.println(pets); //[Rat, Manx, Cymric, Mutt, Pug]
        //1.获取第一个元素
        // Identical(完全相同的):
        System.out.println("pets.getFirst(): " + pets.getFirst()); //pets.getFirst(): Rat
        System.out.println("pets.element(): " + pets.element()); //pets.element(): Rat
        // Only differs in empty-list behavior(仅在空列表行为中有所不同):
        System.out.println("pets.peek(): " + pets.peek()); //pets.peek(): Rat 这里空列表返回null,上面两个报异常
        System.out.println("--------------------------");

        // Identical; 移除并返回第一个元素
        System.out.println("pets.remove(): " + pets.remove()); //pets.remove(): Rat
        System.out.println("pets.removeFirst(): " + pets.removeFirst()); //pets.removeFirst(): Manx
        // Only differs in empty-list behavior(仅在空列表行为中有所不同):
        System.out.println("pets.poll(): " + pets.poll()); //pets.poll(): Cymric

        System.out.println("-------------------------");
        //2.向列表开头添加元素
        System.out.println(pets); //[Mutt, Pug]
        pets.addFirst(new Rat());
        System.out.println("After addFirst(): " + pets); //After addFirst(): [Rat, Mutt, Pug]

        //3.将元素插入列表的末尾
        pets.offer(Pets.randomPet());
        System.out.println("After offer(): " + pets); //After offer(): [Rat, Mutt, Pug, Cymric]
        pets.add(Pets.randomPet());
        System.out.println("After add(): " + pets); //After add(): [Rat, Mutt, Pug, Cymric, Pug]
        pets.addLast(new Hamster());
        System.out.println("After addLast(): " + pets); //After addLast(): [Rat, Mutt, Pug, Cymric, Pug, Hamster]
        //4.移除并返回列表的最后一个元素
        System.out.println("pets.removeLast(): " + pets.removeLast()); //pets.removeLast(): Hamster
    }
}
