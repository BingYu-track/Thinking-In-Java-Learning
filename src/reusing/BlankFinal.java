package reusing;

public class BlankFinal {
    private final int i = 0;
    private final int j;
    private final Poppet p; //空白final必须在构造器中全部初始化，否则编译器就会报错

    public BlankFinal() {
        j = 1;
        p = new Poppet(1);
    }

    public BlankFinal(int x) {
        j = x;
        p = new Poppet(x);
    }
    public static void main(String[] args){
        new BlankFinal();
        new BlankFinal(47);
    }
}
