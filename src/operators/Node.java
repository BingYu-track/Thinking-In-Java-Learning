package operators;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/3/24 14:38
 */
public class Node {

    protected Node next;

    private Integer num;

    public Node(Integer num) {
        this.num = num;
    }

    public Node(Integer num,Node next) {
        this.next = next;
        this.num = num;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
