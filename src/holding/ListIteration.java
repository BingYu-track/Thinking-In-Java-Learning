/**
 * Project: MyTest
 * <p>
 * File Created at 2018/6/10
 * <p>
 * Copyright 2018 e-dewin.com Corporation Limited.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * dewin Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with e-dewin.com.
 */
package holding;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * @Description: ListIterator用法
 * @author: hxw
 * @version 1.0
 * @date: 2018/6/10 12:04
 */
public class ListIteration {

    //  ^Element(0) ^  Element(1) ^  Element(2)  ^ ... Element(n-1)^
    //注意ListIterator 没有当前元素;它的游标位置 始终位于调用 previous() 所返回的元素和调用 next() 所返回的元素之间。
    // 长度为 n 的列表的迭代器有 n+1 个可能的指针位置


    public static void main(String[] args){
        List<Pet> pets = Pets.arrayList(8); //
        ListIterator<Pet> it = pets.listIterator();
        System.out.println(pets); //[Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug, Manx]
        while(it.hasNext()){
            System.out.print(it.next() + ", " + it.nextIndex() + ", " + it.previousIndex() + "; ");
            //it.next() 下一个元素  it.nextIndex()返回对 next 的后续调用所返回元素的索引，注意，此时游标位于第一个元素和第二个元素之间。（如果列表迭代器在列表的结尾，则返回列表的大小）。
            //it.previousIndex()游标的前一个元素的索引
        }
        System.out.println();
        // Backwards: //逆向遍历
        while(it.hasPrevious()){
            System.out.print(it.previous().id() + " ");
        }
        System.out.println();
        System.out.println(pets); //[Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug, Manx]
        it = pets.listIterator(3); //从索引为3的元素开始  相当于游标在索引3元素和索引2元素之间如图： Element(0)   Element(1)  Element(2) ^ Element(3)  ... Element(n-1)
        while(it.hasNext()) {
            System.out.println(it.next()); //Mutt
            it.set(Pets.randomPet()); //set(E e)方法 用指定元素替换 next 或 previous 返回的最后一个元素
        }
        System.out.println(pets); //[Rat, Manx, Cymric, Cymric, Rat, EgyptianMau, Hamster, EgyptianMau]

    }
}
