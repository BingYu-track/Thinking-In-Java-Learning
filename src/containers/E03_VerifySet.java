package containers;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import static net.mindview.util.Countries.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/1/29 21:24
 */
public class E03_VerifySet {

    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<String>();
        for(int i = 0; i < 5; i++)
            set.addAll(names(10));
        System.out.println(set); //[ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD]
        //LinkedHashSet内部使用链表维护元素插入的顺序
    }

    @Test
    public void testHashSet(){
        Set<String> set = new HashSet<String>();
        for(int i = 0; i < 5; i++)
            set.addAll(names(10));
        System.out.println(set); //[BENIN, BOTSWANA, CENTRAL AFRICAN REPUBLIC, CHAD, CAMEROON, CAPE VERDE, ANGOLA, BURKINA FASO, ALGERIA, BURUNDI]
        //HashSet无序
    }

    @Test
    public void testTreeSet(){
        Set<String> set = new TreeSet<String>();
        for(int i = 0; i < 5; i++)
            set.addAll(names(10));
        System.out.println(set); //[ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD]
    }
}
