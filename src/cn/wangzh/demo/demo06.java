package cn.wangzh.demo;

public class demo06 {
	public static void main(String[] args){
		String reg = "(\\d+(,\\d+)?)";
		String a ="1,1";
		System.out.println(a.matches(reg));
	}

}
