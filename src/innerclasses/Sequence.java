package innerclasses;

public class Sequence {

    private Object[] items;
    private int next = 0;
    public Sequence(int size) {
        items = new Object[size];
    }
    public void add(Object x) {
        if(next < items.length) {
            System.out.println(next);
            items[next++] = x;
            System.out.println(next);
        }
    }
    private class SequenceSelector implements Selector { //private类自动拥有外部类的所有访问权限   迭代器设计模式
        private int i = 0;
        public boolean end() {
            return i == items.length;
        }
        public Object current() { return items[i]; }
        public void next() { if(i < items.length) i++; }

        public Sequence getOutter(){
            return Sequence.this;
        }
    }
    public Selector selector() {
        return new SequenceSelector();
    }
    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for(int i = 0; i < 10; i++){
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.selector();
        while(!selector.end()) { //如果不是最后一个元素
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}
