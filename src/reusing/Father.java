package reusing;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/1 22:34
 */
public class Father {
    private String name = "hxw";//私有属性
    private String sex = "man";

    public void tell(){
        System.out.println(name+sex);
    }

    private void speak(){
        System.out.println(name+"is speaking!");
    }

}
