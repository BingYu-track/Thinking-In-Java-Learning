package generics;

import java.util.*;

/**
 * @version 1.0
 * @Description: 银行柜员
 * @author: hxw
 * @date: 2018/10/6 18:26
 */
public class BankTeller {

    public static void serve(Teller t, Customer c) {
        System.out.println(t + " serves " + c);
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        Queue<Customer> line = new LinkedList<Customer>();
        //填充消费者队列
        Generators.fill(line, Customer.generator(), 15);
        List<Teller> tellers = new ArrayList<Teller>();
        //填充服务者列表
        Generators.fill(tellers, Teller.generator, 4);
        for(Customer c : line) {
            //随机选取一个服务者
            Teller teller = tellers.get(rand.nextInt(tellers.size()));
            serve(teller,c);
        }
    }
}
