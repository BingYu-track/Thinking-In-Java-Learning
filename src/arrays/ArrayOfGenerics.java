package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/31 22:46
 */
public class ArrayOfGenerics {

    //@SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<String>[] ls;
        List[] la = new List[10];
        ls = (List<String>[])la; // "Unchecked" warning
        ls[0] = new ArrayList<String>();
        // 产生编译错误: ls[1] = new ArrayList<Integer>();
        // The problem: List<String> is a subtype of Object
        Object[] objects = ls; // So assignment is OK
        // Compiles and runs without complaint:
        objects[1] = new ArrayList<Integer>();
        // However, if your needs are straightforward it is possible to create an array of generics, albeit with an "unchecked" warning:
        List<BerylliumSphere>[] spheres = (List<BerylliumSphere>[])new List[10];
        for(int i = 0; i < spheres.length; i++){
            spheres[i] = new ArrayList<BerylliumSphere>();
        }
    }
}
