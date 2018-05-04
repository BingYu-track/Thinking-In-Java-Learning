package innerclasses.exercise22;

import innerclasses.Selector;
import innerclasses.Sequence;

public class Sequence3 {

    private Object[] items;
    private int next = 0;
    public Sequence3(int size) {
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

        public Sequence3 getOutter(){
            return Sequence3.this;
        }
    }

    private class ReverseSelector implements Selector{ //反序列排序
        int i = items.length - 1;

        @Override
        public boolean end() {
            return i < 0 ;   //小于0说明已经到末尾
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if(i >= 0) i--;
        }
    }

    public Selector selector() {
        return new Sequence3.SequenceSelector();
    }

    public Selector reverseSelector(){
        return new Sequence3.ReverseSelector();
    }

    /*public static void main(String[] args) {
        Sequence3 sequence = new Sequence3(10);
        for(int i = 0; i < 10; i++){
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.selector();
        while(!selector.end()) { //如果不是最后一个元素
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }*/

    public static void main(String[] args) {
        Sequence3 sequence = new Sequence3(10);
        for(int i = 0; i < 10; i++){
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.reverseSelector();
        while(!selector.end()) { //如果不是最后一个元素
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }


}
