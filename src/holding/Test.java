/**
 * Project: MyTest
 * <p>
 * File Created at 2018/6/11
 * <p>
 * Copyright 2018 e-dewin.com Corporation Limited.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * dewin Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with e-dewin.com.
 */
package holding;

import java.util.*;

/**
 * @Description:
 * @author: hxw
 * @version 1.0
 * @date: 2018/6/11 10:02
 */
public class Test {

    public static void main(String[] args){
        /*ArrayList<Integer> listdb = new ArrayList<>(); //模拟已选择的列表(db)
        listdb.add(1);
        listdb.add(2);
        listdb.add(3);
        listdb.add(4);
        listdb.add(5);
        ArrayList<Integer> listdbcopy1 = new ArrayList<>(listdb); //创建一个副本(db)
        System.out.println(listdb);
        ArrayList<Integer> listPage = new ArrayList<>(); //移除了 1和3，增加了6 (页面传进来的)
        listPage.add(2);
        listPage.add(4);
        listPage.add(5);
        listPage.add(6);
        System.out.println(listPage);
        boolean remove = listdb.removeAll(listPage);
        System.out.println("已移除的id："+listdb);
        listdbcopy1.retainAll(listPage);
        System.out.println("需要编辑的id:"+listdbcopy1);
        listPage.removeAll(listdbcopy1);
        System.out.println("新增的id："+listPage);*/
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(8);
        queue.offer(5);
        queue.offer(7);
        queue.offer(9);
        queue.offer(6);
        queue.offer(1);
        System.out.println(queue);
    }
}
