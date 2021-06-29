package annotations.simplest;

/**
 * @version 1.0
 * @Description:
 * @author: bingyu
 * @date: 2021/6/29
 */
@Simple
public class SimpleTest {

    @Simple
    int i;
    @Simple
    public SimpleTest() {}
    @Simple
    public void foo() {
        System.out.println("SimpleTest.foo()");
    }
    @Simple
    public void bar(String s, int i, float f) {
        System.out.println("SimpleTest.bar()");
    }
    @Simple
    public static void main(String[] args) {
        @Simple
        SimpleTest st = new SimpleTest();
        st.foo();
    }
}
