package typeinfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/29 21:25
 */
public class FilledList<T> {

    private Class<T> type;

    public FilledList(Class<T> type) { //这里限定了只有带参的构造方法，保证在调用create方法时用到的type始终是存在的
        this.type = type;
    }

    public List<T> create(int nElements) {
        List<T> result = new ArrayList<T>();
        try {
            for(int i = 0; i < nElements; i++){
                result.add(type.newInstance()); //再次提醒使用newInstance()时必须保证该类是有无参构造器的
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void main(String[] args) {
        FilledList<CountedInteger> fl = new FilledList<CountedInteger>(CountedInteger.class);
        List<CountedInteger> list = fl.create(15); //Class使用泛型后newInstance()返回的就是具体的对象，而不再是Object
        System.out.println(list); //这里其实里面是循环调用List里对象的toString()方法
    }
}
