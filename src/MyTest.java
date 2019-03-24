import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.rmi.CORBA.Stub;

public class MyTest {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println(list);
		for (Integer i : list) {
			list.remove(i);
		}
	}
	

}
