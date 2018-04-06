package polymorphism;

/**
* @Description:多个对象共享一个示例(创建顺序和销毁顺序)
* @Author:hxw
* @Date:2018/4/6 20:32
*/
public class ReferenceCounting {

    public static void main(String[] args) {
        Shared shared = new Shared();
        Composing[] composing = {
                new Composing(shared), //id=0
                new Composing(shared), //id=1
                new Composing(shared), //id=2
                new Composing(shared), //id=3
                new Composing(shared) //id=4
                };
        for(Composing c : composing)
            c.dispose();
            System.gc();
        // Verify failure:
         Composing c = new Composing(new Shared());
         //c.dispose();
        System.gc();
    }
    /*执行结果 总结：当一个示例被多个对象共享时，想要清除该共享对象，只有当引用该共享对象的其它对象全部清理掉才会再清理共享对象。
      Creating Shared 0
      Creating Composing 0
      Creating Composing 1
      Creating Composing 2
      Creating Composing 3
      Creating Composing 4
      disposing Composing 0
      disposing Composing 1
      disposing Composing 2
      disposing Composing 3
      disposing Composing 4
      Disposing Shared 0
    * */
}
