package typeinfo;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/28 22:31
 */
 class Initable {

    static final int staticFinal = 47; //编译时常量
    static final int staticFinal2 =  ClassInitialization.rand.nextInt(1000); //运行时常量
    static {
        System.out.println("Initializing Initable");
    }
}
