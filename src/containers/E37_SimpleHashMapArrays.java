package containers;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/9 23:14
 */
public class E37_SimpleHashMapArrays {

    public static void main(String[] args) {
        if(args.length > 0){
            Tester.defaultParams = TestParam.array(args);
        }
        Tester.run(new SimpleHashMap4<Integer,Integer>(), E35_MapPerformance2.tests);
        Tester.run(new SimpleHashMap5<Integer,Integer>(), E35_MapPerformance2.tests);
        Tester.run(new SimpleHashMap6<Integer,Integer>(), E35_MapPerformance2.tests);
    }
}
