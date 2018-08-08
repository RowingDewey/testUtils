package cn.wangzh.demo;

public class demo02 {
	public static void main(String[] args){
		String str = "11,2";
		if((!"".equals(str)) && ("1,2".equals(str) || "2,1".equals(str) || "2".equals(str))){
			System.out.println(true);
		}else{
			System.out.println(false);
		}
		
		 //System.out.println(str.equals("1,2"));
	}
	
	public static boolean isCheck(String s)
	{
		boolean check = false;
		String[] as = s.split(",");
		if((as[0].equals("2") && as[1].equals("1")) 
			|| (as[1].equals("2") && as[0].equals("1")))
		{
			check = true;
		}
		return check;
	}
	

}
