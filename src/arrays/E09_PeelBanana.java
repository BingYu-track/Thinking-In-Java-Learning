package arrays;

import java.util.ArrayList;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/31 23:10
 */
public class E09_PeelBanana {

    public static void main(String[] args) {
        // Compile error:
        //! Peel<Banana>[] a = new Peel<Banana>[10];
        ArrayList<Peel<Banana>> a = new ArrayList<Peel<Banana>>();
        for(int i = 0; i < 10; i++){
            a.add(new Peel<Banana>(new Banana(i)));
        }
        for(Peel<Banana> p : a){
            p.peel();
        }
    }
}
