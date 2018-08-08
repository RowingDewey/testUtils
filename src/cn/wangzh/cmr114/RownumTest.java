package cn.wangzh.cmr114;

public class RownumTest {
	public static void main(String[] args) {
		

		System.out.println("result=" +getvalue());
	}
	public static Object getvalue() {
		boolean flag = true; 
		int count = 10;
		int start = 0;
		int i = 0;
		while(flag)
		{
			int j = 0;
			for (;i < 5; i++) {
				start += count;
				if( i == 4)
				{
					flag =false;
				}
				j ++;
			}
			System.out.println("j=" + j);
		}
		return start;
	}
}
