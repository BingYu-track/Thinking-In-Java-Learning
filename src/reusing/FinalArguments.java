package reusing;

/**
* @Description:final参数
* @Author:hxw
* @Date:2018/4/5 14:55
*/
public class FinalArguments {

    void with(final Gizmo g){
        //g = new Gizmo();  //报错，无法给final修饰的g变量赋值
        System.out.println(g);
    }

    void without(Gizmo g){
        g = new Gizmo();
        g.spin();
    }

    int g(final int i){
        return i+1;
    }

    public static void main(String[] args){
        FinalArguments bf = new FinalArguments();
        bf.without(null);
        bf.with(null);
    }
    //总结：当参数被指定为final时，你只能读参数，但无法修改参数。
}
