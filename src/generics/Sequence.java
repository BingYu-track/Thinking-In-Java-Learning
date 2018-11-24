package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/24 14:11
 */
class Sequence<T> {

    private Object[] items;
    private int next; //初始为0(一个游标
    // )
    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(T x) {
        if(next < items.length)
            items[next++] = x;
    }

    //迭代器设计模式
    private class SequenceSelector implements Selector<T> {
        private int i; //Selector游标，用来保存当前遍历的元素位置

        public boolean end() {
            return i == items.length;
        }

        @SuppressWarnings("unchecked")
        public T current() {
            return (T)items[i];
        }

        public void next() {
            if(i < items.length) i++;
        }

    }

    public Selector<T> selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args){
        Sequence<Integer> sequence = new Sequence<>(10);
        sequence.add(1);
        sequence.add(2);
        sequence.add(3);
        sequence.add(4);
        Selector<Integer> selector = sequence.selector();
        while (!selector.end()){
            Integer current = selector.current();
            System.out.println(current);
            selector.next();
        }
    }
}
