package containers;

import java.util.*;
import static net.mindview.util.Countries.*;

/**
 * @version 1.0
 * @Description: TreeMap.headMap()方法和TreeSet.headSet()方法
 * @author: hxw
 * @date: 2019/1/28 23:00
 */
public class E02_ACountries {

    public static void main(String[] args) {
        Map<String, String> capitals = capitals(); //这里返回的map包含所有的国家和首都映射
        TreeMap<String,String> map = new TreeMap<String,String>(capitals);
        List<String> names = names(); //获取所有国家名
        System.out.println(names); //[ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, ......
        TreeSet<String> set = new TreeSet<String>(names);//放入TreeSet后自动排序了
        System.out.println(set); //[AFGHANISTAN, ALBANIA, ALGERIA, ANDORRA, ANGOLA, ANTIGUA AND BARBUDA, ARGENTINA, ARMENIA, AUSTRALIA, AUSTRIA, AZERBAIJAN, BAHAMAS, BAHRAIN, BANGLADESH......
        String b = null;
        for(String s : map.keySet()){
            if(s.startsWith("B")) { //找到第一个以B开头的字符串
                b = s;
                break;
            }
        }
        Map<String,String> aMap = map.headMap(b); //返回这个Map中严格小于b的部分映射
        Set<String> aSet = set.headSet(b); //返回这个set中严格小于b的元素
        System.out.println("aMap = " + aMap); //aMap = {AFGHANISTAN=Kabul, ALBANIA=Tirana, ALGERIA=Algiers, ANDORRA=Andorra la Vella, ANGOLA=Luanda, ANTIGUA AND BARBUDA=Saint John's, ARGENTINA=Buenos Aires, ARMENIA=Yerevan, AUSTRALIA=Canberra, AUSTRIA=Vienna, AZERBAIJAN=Baku}
        System.out.println("aSet = " + aSet);//aSet = [AFGHANISTAN, ALBANIA, ALGERIA, ANDORRA, ANGOLA, ANTIGUA AND BARBUDA, ARGENTINA, ARMENIA, AUSTRALIA, AUSTRIA, AZERBAIJAN]
    }
}
