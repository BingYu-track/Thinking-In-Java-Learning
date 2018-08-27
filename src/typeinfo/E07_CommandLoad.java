package typeinfo;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/27 22:11
 */
public class E07_CommandLoad {

    public static void main(String[] args) throws Exception {
        args = new String[]{"typeinfo.Candy","typeinfo.Gum"};
        for(String arg : args)
            Class.forName(arg);
    }
}
