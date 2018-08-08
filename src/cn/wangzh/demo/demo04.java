package cn.wangzh.demo;

public class demo04 {
	public String getsss(){
		if(true)
		{
			if("".equals("1"))
			{
				return "";
			}
			System.out.println("2");
		}
		return "3";
	}
	public static void main(String[] args){
		demo04 d = new demo04();
		String dd = d.getsss();
	}

}
