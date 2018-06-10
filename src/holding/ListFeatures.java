package holding;

import typeinfo.pets.*;

import java.util.*;

/**
 * @Description:
 * @author: hxw
 * @version 1.0
 * @date: 2018/6/4 15:46
 */
public class ListFeatures {

    public static void main(String[] args){
        Random rand = new Random(47);
        List<Pet> pets = Pets.arrayList(7);  //返回一个填充了随机选取的Pet对象的ArrayList:
        System.out.println("1: " + pets); //1: [Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug]
        Hamster h = new Hamster();  //仓鼠
        pets.add(h); // 自动调整大小
        System.out.println("2: " + pets); //2: [Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug, Hamster]
        System.out.println("3: " + pets.contains(h)); //3: true
        pets.remove(h); // Remove by object
        Pet p = pets.get(2);
        System.out.println("4: " + p + " " + pets.indexOf(p));//4: Cymric 2
        Pet cymric = new Cymric();
        System.out.println("5: " + pets.indexOf(cymric)); //5: -1  新创建的对象是否会包含进去
        System.out.println("6: " + pets.remove(cymric)); //6: false
        // Must be the exact object: 必须是精确的对象
        System.out.println("7: " + pets.remove(p)); //7: true
        System.out.println("8: " + pets); //8: [Rat, Manx, Mutt, Pug, Cymric, Pug]
        pets.add(3, new Mouse()); // 将对象插入指定索引
        System.out.println("9: " + pets); //9: [Rat, Manx, Mutt, Mouse, Pug, Cymric, Pug]
        List<Pet> sub = pets.subList(1, 4); //截取list形成一个小列表(左包含，右不包含)
        System.out.println("subList: " + sub);
        System.out.println("10: " + pets.containsAll(sub));  //10: true 是否包含一个小列表
        Collections.sort(sub); // In-place sort
        System.out.println("sorted subList: " + sub); //sorted subList: [Manx, Mouse, Mutt]
        // Order is not important in containsAll():
        System.out.println("11: " + pets.containsAll(sub)); //11: true   如果列表包含指定 collection 的所有元素，则返回 true,不关心排序
        Collections.shuffle(sub, rand); // Mix it up 将List中的内容随机打乱顺序
        System.out.println("shuffled subList: " + sub);  //shuffled subList: [Mouse, Manx, Mutt]
        System.out.println("12: " + pets.containsAll(sub)); //12: true
        List<Pet> copy = new ArrayList<Pet>(pets); //复制一份列表
        sub = Arrays.asList(pets.get(1), pets.get(4));
        System.out.println("sub: " + sub); //sub: [Mouse, Pug]
        copy.retainAll(sub); //移除此 sub 中未包含在指定 collection 中的所有元素,即取交集。
        System.out.println("13: " + copy); //13: [Mouse, Pug]
        copy = new ArrayList<Pet>(pets); // Get a fresh copy
        copy.remove(2); // Remove by index 根据下标移除元素
        System.out.println("14: " + copy);  //14: [Rat, Mouse, Mutt, Pug, Cymric, Pug]
        copy.removeAll(sub); // Only removes exact objects
        System.out.println("15: " + copy); // 15: [Rat, Mutt, Cymric, Pug]
        copy.set(1, new Mouse()); // Replace an element 替换元素
        System.out.println("16: " + copy);  //16: [Rat, Mouse, Cymric, Pug]
        copy.addAll(2, sub); // Insert a list in the middle 中间插入一个list 
        System.out.println("17: " + copy); //17: [Rat, Mouse, Mouse, Pug, Cymric, Pug]
        System.out.println("18: " + pets.isEmpty()); //18: false
        pets.clear(); // Remove all elements 清空列表中的所有元素
        System.out.println("19: " + pets); //19: []
        System.out.println("20: " + pets.isEmpty()); //20: true
        pets.addAll(Pets.arrayList(4));
        System.out.println("21: " + pets); //21: [Manx, Cymric, Rat, EgyptianMau]
        Object[] o = pets.toArray(); //返回一个包含列表中的所有元素的数组
        System.out.println("22: " + o[3]); //22: EgyptianMau
        Pet[] pa = pets.toArray(new Pet[0]); //返回一个包含列表中的所有元素的数组,必须指定数组类型
        System.out.println("23: " + pa[3].id()); //23: 14
    }
}
