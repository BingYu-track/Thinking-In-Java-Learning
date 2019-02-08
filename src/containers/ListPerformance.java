package containers;

import net.mindview.util.CountingGenerator;
import net.mindview.util.CountingIntegerList;
import net.mindview.util.Generated;

import java.util.*;

/**
 * @version 1.0
 * @Description: 性能测试
 * @author: hxw
 * @date: 2019/2/8 17:59
 */
public class ListPerformance {

    static Random rand = new Random();
    static int reps = 1000;
    static List<Test<List<Integer>>> tests = new ArrayList<Test<List<Integer>>>(); //用来存储List的测试对象列表(后面会用它调用Tester的有参构造器)
    static List<Test<LinkedList<Integer>>> qTests = new ArrayList<Test<LinkedList<Integer>>>();
    static {
        tests.add(
            new Test<List<Integer>>("add") {
                int test(List<Integer> list, TestParam tp) {
                    int loops = tp.loops;
                    int listSize = tp.size;
                    for (int i = 0; i < loops; i++) {
                        list.clear();
                        for (int j = 0; j < listSize; j++)
                            list.add(j);
                    }
                    return loops * listSize;
                }
            }
        );

        tests.add(new Test<List<Integer>>("get") {
            int test(List<Integer> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for (int i = 0; i < loops; i++) //loops次
                    list.get(rand.nextInt(listSize));
                return loops;
            }
        });

        tests.add(new Test<List<Integer>>("set") {
            int test(List<Integer> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for(int i = 0; i < loops; i++)
                    list.set(rand.nextInt(listSize), 47);
                return loops;
            }
        });

        tests.add(new Test<List<Integer>>("iteradd") {
            int test(List<Integer> list, TestParam tp) {
                final int LOOPS = 1000000;
                int half = list.size() / 2;
                ListIterator<Integer> it = list.listIterator(half);
                for(int i = 0; i < LOOPS; i++)
                    it.add(47);
                return LOOPS;
            }
        });

        tests.add(new Test<List<Integer>>("insert") {
            int test(List<Integer> list, TestParam tp) {
                int loops = tp.loops;
                for(int i = 0; i < loops; i++)
                    list.add(5, 47); // Minimize random-access cost
                return loops;
            }
        });

        tests.add(new Test<List<Integer>>("remove") {
            int test(List<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(new CountingIntegerList(size));
                    while(list.size() > 5)
                        list.remove(5); // Minimize random-access cost
                }
                return loops * size;
            }
        });

        // Tests for queue behavior:
        qTests.add(new Test<LinkedList<Integer>>("addFirst") {
            int test(LinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++) {
                    list.clear();
                    for(int j = 0; j < size; j++)
                        list.addFirst(47);
                }
                return loops * size;
            }
        });

        qTests.add(new Test<LinkedList<Integer>>("addLast") {
            int test(LinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++) {
                    list.clear();
                    for(int j = 0; j < size; j++)
                        list.addLast(47);
                }
                return loops * size;
            }
        });

        qTests.add(
                new Test<LinkedList<Integer>>("rmFirst") {
                    int test(LinkedList<Integer> list, TestParam tp) {
                        int loops = tp.loops;
                        int size = tp.size;
                        for(int i = 0; i < loops; i++) {
                            list.clear();
                            list.addAll(new CountingIntegerList(size));
                            while(list.size() > 0)
                                list.removeFirst();
                        }
                        return loops * size;
                    }
                });

        qTests.add(new Test<LinkedList<Integer>>("rmLast") {
            int test(LinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(new CountingIntegerList(size));
                    while(list.size() > 0)
                        list.removeLast();
                }
                return loops * size;
            }
        });

    }

    static class ListTester extends Tester<List<Integer>> {
        public ListTester(List<Integer> container, List<Test<List<Integer>>> tests) {
            super(container, tests);
        }
        // Fill to the appropriate size before each test:
        @Override
        protected List<Integer> initialize(int size){
            container.clear();
            container.addAll(new CountingIntegerList(size));
            return container;
        }
        // Convenience method:
        public static void run(List<Integer> list, List<Test<List<Integer>>> tests) {
            new ListTester(list, tests).timedTest();
        }
    }

    public static void main(String[] args) {
        if(args.length > 0){
            Tester.defaultParams = TestParam.array(args);
        }
        // 创建了一个Tester对象
        Tester<List<Integer>> arrayTest = new Tester<List<Integer>>(null, tests.subList(1, 3)){ //这里使用了subList，只测试get和set方法
            // This will be called before each test. It produces a non-resizeable array-backed list:这将在每次测试之前调用。它生成一个不可调整大小的数组支持列表。
            @Override
            protected List<Integer> initialize(int size) {
                Integer[] ia = Generated.array(Integer.class, new CountingGenerator.Integer(), size);
                return Arrays.asList(ia);
            }
        };
        arrayTest.setHeadline("Array as List");
        arrayTest.timedTest();
        Tester.defaultParams= TestParam.array(10, 5000, 100, 5000, 1000, 1000, 10000, 200);
        if(args.length > 0){
            Tester.defaultParams = TestParam.array(args);
        }
        ListTester.run(new ArrayList<Integer>(), tests);
        ListTester.run(new LinkedList<Integer>(), tests);
        ListTester.run(new Vector<Integer>(), tests);
        Tester.fieldWidth = 12;
        Tester<LinkedList<Integer>> qTest = new Tester<LinkedList<Integer>>(new LinkedList<Integer>(), qTests);
        qTest.setHeadline("Queue tests");
        qTest.timedTest();
    }
}
