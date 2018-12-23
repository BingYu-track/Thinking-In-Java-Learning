package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/23 23:27
 */
class FillTest {
    public static void main(String[] args) {
        List<Contract> contracts = new ArrayList<Contract>();
        Fill.fill(contracts, Contract.class, 3);
        Fill.fill(contracts, TitleTransfer.class, 2);
        for(Contract c: contracts)
            System.out.println(c);
        SimpleQueue<Contract> contractQueue = new SimpleQueue<Contract>();
        // Won’t work. fill() is not generic enough:
         //Fill.fill(contractQueue, Contract.class, 3);

    }
}
