package cm;

import java.util.ArrayList;
import java.util.List;

public class TestConllection {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		List<String> list1=new ArrayList<String>();
		list.add("1");
		list.add("12");
		list.add("123");
		list1.add("12");
		list1.add("123");
		System.out.println("flag:"+list.removeAll(list1));
		System.out.println(list.size());
		System.out.println(list.get(0));
	}

}
