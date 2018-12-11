package generics;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/11 22:12
 */
public class NeedCasting {

    //@SuppressWarnings("unchecked")
    public void f(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
        List<Widget> shapes = (List<Widget>)in.readObject(); //产生转型警告
    }
}
