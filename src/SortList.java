import java.util.ArrayList;
import java.util.Collections;

public class SortList {

    public static void main(String[] args){
        ArrayList<RoomStatusVo> roomStatusVos = new ArrayList<>();
        RoomStatusVo r1 = new RoomStatusVo(23);
        RoomStatusVo r2 = new RoomStatusVo(15);
        RoomStatusVo r3 = new RoomStatusVo(99);
        RoomStatusVo r4 = new RoomStatusVo(86);
        RoomStatusVo r5 = new RoomStatusVo(100);
        RoomStatusVo r6 = new RoomStatusVo(45);
        roomStatusVos.add(r1);
        roomStatusVos.add(r2);
        roomStatusVos.add(r3);
        roomStatusVos.add(r4);
        roomStatusVos.add(r5);
        roomStatusVos.add(r6);
        System.out.println("排序前"+roomStatusVos);
        Collections.sort(roomStatusVos);
        System.out.println("排序后"+roomStatusVos);
    }
}
