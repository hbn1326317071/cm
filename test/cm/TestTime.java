package cm;

import java.util.Date;

public class TestTime {
	public static void main(String[] args) {
		Date date=new Date();
		long time=date.getTime()-1481900000000L;
		System.out.println("time:"+time);
		System.out.println((int)time);
		
//		1481977920925-1481900000000
//		214203805
	}

}
