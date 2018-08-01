package exceptions;

/**
 * @version 1.0
 * @Description: 构造器中出现异常的编程思想
 * @author: hxw
 * @date: 2018/8/1 8:28
 */
public class CleanupIdiom {

    public static void main(String[] args) {
        // Section 1:这里NeedsCleanup构造器没有"声明异常"说明构造不会失败，因此这里不需要catch，直接try-finally清除对象
        NeedsCleanup nc1 = new NeedsCleanup();
        try {
        // ...
        } finally {
            nc1.dispose();
        }
        // Section 2:
        // 不会失败的构造函数的对象可以放在一起，以便进行构造和清理
        NeedsCleanup nc2 = new NeedsCleanup();
        NeedsCleanup nc3 = new NeedsCleanup();
        try {
        // ...
        } finally {
            //按照初始化顺序逆序清理
            nc3.dispose();
            nc2.dispose();
        }
        // Section 3:
        // 如果构造器有"声明异常",你必须将每一个构造器都包含在他们自己的try-catch语句块中，并且后面都要跟随一个try-finally语句块确保清理
        try {
            NeedsCleanup2 nc4 = new NeedsCleanup2();
            try {
                NeedsCleanup2 nc5 = new NeedsCleanup2();
                try {
                // ...
                } finally {
                    nc5.dispose();
                }
            } catch(ConstructionException e) { // nc5 constructor
                System.out.println(e);
            } finally {
                nc4.dispose();
            }
        } catch(ConstructionException e) { // nc4 constructor
            System.out.println(e);
        }
    }
}
