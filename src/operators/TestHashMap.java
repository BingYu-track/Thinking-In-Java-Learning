package operators;

/**
 * @version 1.0
 * @Description: 模拟jdk1.7 HashMap并发情况下产生"链表环"
 * @author: hxw
 * @date: 2019/3/24 17:38
 */
public class TestHashMap {

    private Node[] oldTable = new Node[]{null,new Node(3,new Node(7,new Node(5)))};

    public static void main(String[] args){
        TestHashMap map = new TestHashMap();
        Node[] newTable = new Node[4];
        //线程1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                map.transfer(newTable);
            }
        });
        //线程2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                map.transfer(newTable);
            }
        });
        t1.setName("1");
        t2.setName("2");
        t1.start();
        t2.start();
    }

    //模拟jdk1.7的hashMap扩容时的元素迁移
    public void transfer(Node[] newTable){
        int newCapacity = newTable.length;
        for (int j = 0; j < oldTable.length; j++) { //遍历旧的Entry数组
            System.out.println(j < oldTable.length);
            Node e = oldTable[j];  //取得旧Entry数组的每个元素
            if (e != null) {
                //oldTable[j] = null; //释放旧Entry数组对象引用
                do {
                    Thread t = Thread.currentThread();
                    if(t.getName().equals("1")){
                        try {
                            Thread.sleep(40000);  //让t1线程睡眠
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                    }
                    Node next = e.next;
                    int i = indexFor(e.getNum(), newCapacity); //重新计算每个元素在新数组中的位置
                    e.next = newTable[i];  //第一次计算这里为null，第二次计算的话放在已有元素的前面(头查法) 最终这里导致了循环引用
                    newTable[i] = e; //将元素e放入数组i位置的头结点
                    e = next; //获取e的后继结点
                } while (e != null);
            }
        }
    }

    //对长度取模
    public static int indexFor(Integer num, int newCapacity) {
        return num % newCapacity;
    }


}
