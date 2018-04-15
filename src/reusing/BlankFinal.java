package reusing;

/**
* @Description:空白final
* @Author:hxw
* @Date:2018/4/5 14:55
*/
public class BlankFinal {
    private final int i = 0;
    private final int j;
    private final Poppet p; //空白final必须在使用前在"每一个构造器中"全部初始化，否则编译器就会报错

    public BlankFinal() { //无参构造器
        j = 1;
        p = new Poppet(1);
    }

    public BlankFinal(int x) {
        j = x;
        p = new Poppet(x);
    }
    public static void main(String[] args){
        BlankFinal blankFinal1 = new BlankFinal();
        BlankFinal blankFinal2 = new BlankFinal(47);//这两个对象中的final成员j、p的值就不一样。
    }

}
