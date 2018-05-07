package innerclasses;

public class LocalInnerClass {

    private int count = 0;
    Counter getCounter(final String name) { //方法
        // 局部内部类:
        class LocalCounter implements Counter {
            public LocalCounter() { // 局部内部类构造器
                System.out.println("LocalCounter()");
            }
            public int next() {
                System.out.println(name); // Access local final
                return count++;
            }
        }
        return new LocalCounter();
    }
    // 匿名内部类也是一样:
    Counter getCounter2(final String name) {
        return new Counter() {
            // 匿名内部类没有名字
            // 初始化代码块充当匿名内部类的构造器
            {
                System.out.println("Counter()");
            }
            public int next() {
                System.out.println(name); // Access local final
                return count++;
            }
        };
    }
    public static void main(String[] args) {
        LocalInnerClass lic = new LocalInnerClass();
        Counter c1 = lic.getCounter("Local inner "),c2 = lic.getCounter2("Anonymous inner ");
        for(int i = 0; i < 5; i++){
            System.out.println(c1.next());
        }
        for(int i = 0; i < 5; i++){
            System.out.println(c2.next());
        }
    }
}
