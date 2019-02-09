package containers;

import java.util.*;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/9 22:13
 */
public class E36_MapEntrySlowMap {

    public static void main(String[] args) {
        // Testing correctness...
        System.out.println("Testing MapEntrySlowMap1");
        E16_SlowMapTest.test(new MapEntrySlowMap1<Integer,String>());
        System.out.println("Testing MapEntrySlowMap2");
        E16_SlowMapTest.test(new MapEntrySlowMap2<Integer,String>());
        // Measuring performance...
        if(args.length > 0){
            Tester.defaultParams = TestParam.array(args);
        }
        Tester.run(new TreeMap<Integer,Integer>(), E35_MapPerformance2.tests);
        Tester.run(new HashMap<Integer,Integer>(), E35_MapPerformance2.tests);
        Tester.run(new LinkedHashMap<Integer,Integer>(), E35_MapPerformance2.tests);
        Tester.run(new IdentityHashMap<Integer,Integer>(), E35_MapPerformance2.tests);
        Tester.run(new WeakHashMap<Integer,Integer>(), E35_MapPerformance2.tests);
        Tester.run(new Hashtable<Integer,Integer>(), E35_MapPerformance2.tests);
        Tester.run(new SlowMap2<Integer,Integer>(), E35_MapPerformance2.tests);
        Tester.run(new MapEntrySlowMap1<Integer,Integer>(), E35_MapPerformance2.tests); //使用ArraryList持有对象组MapEntry
        Tester.run(new MapEntrySlowMap2<Integer,Integer>(), E35_MapPerformance2.tests); //在MapEntrySlowMap2基础上修改了put()方法和getEntry()方法
    }
}
/*
    ---------- TreeMap ----------
 size     put     get iterate
   10     150      63      20
  100      46      19       5
 1000      55      36       5
10000      66      43       5
---------- HashMap ----------
 size     put     get iterate
   10      79      57      37
  100       7       2       4
 1000      10       4       4
10000      14       3       4
------- LinkedHashMap -------
 size     put     get iterate
   10      61      23       9
  100      18       6       4
 1000      21       8       4
10000      30       8       4
------ IdentityHashMap ------
 size     put     get iterate
   10      66      19      16
  100      17      16      10
 1000      33      38      12
10000      47      50      13
-------- WeakHashMap --------
 size     put     get iterate
   10      63      21      12
  100      32       5       7
 1000      16       7      10
10000      17       6      42
--------- Hashtable ---------
 size     put     get iterate
   10      47      17      12
  100      26      16       6
 1000      21      21       6
10000      23      18       6
---------- SlowMap2 ----------
 size     put     get iterate
   10      66      43      13
  100      86      84       7
 1000     729     702       7
10000    8025    7677       7
------ MapEntrySlowMap1 ------
 size     put     get iterate
   10     119      71      11
  100      58     115       5
 1000     549    1020       5
10000    6552   10999       5
------ MapEntrySlowMap2 ------
 size     put     get iterate
   10     135      86       6
  100     166      26       5
 1000    1544      40       5
10000   23764      51       5
*/