package containers;

import java.util.PriorityQueue;

/**
 * @version 1.0
 * @Description: 优先队列
 * @author: hxw
 * @date: 2019/2/5 18:19
 */
class ToDoList extends PriorityQueue<ToDoList.ToDoItem> {

    static class ToDoItem implements Comparable<ToDoItem> {
        private char primary; //主要优先级值
        private int secondary; //次要优先级值
        private String item;
        public ToDoItem(String td, char pri, int sec) {
            primary = pri;
            secondary = sec;
            item = td;
        }
        //通过实现的Comparable接口而绝定了优先级队列的排序顺序
        public int compareTo(ToDoItem arg) {
            if(primary > arg.primary){ //先比较primary
                return +1;
            }
            if(primary == arg.primary){ //primary相等，再比较secondary
                if(secondary > arg.secondary)
                    return +1;
                else if(secondary == arg.secondary)
                    return 0;
            }
            return -1;
        }

        public String toString() {
            return Character.toString(primary) + secondary + ": " + item;
        }

    }

    public void add(String td, char pri, int sec) {
        super.add(new ToDoItem(td, pri, sec));
    }
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.add("Empty trash", 'C', 4);
        toDoList.add("Feed dog", 'A', 2);
        toDoList.add("Feed bird", 'B', 7);
        toDoList.add("Mow lawn", 'C', 3);
        toDoList.add("Water lawn", 'A', 1);
        toDoList.add("Feed cat", 'B', 1);
        while(!toDoList.isEmpty()){
            System.out.println(toDoList.remove());
        }
    }
}
/*
A1: Water lawn
A2: Feed dog
B1: Feed cat
B7: Feed bird
C3: Mow lawn
C4: Empty trash
*/
