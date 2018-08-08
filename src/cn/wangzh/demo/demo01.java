package cn.wangzh.demo;

public class demo01 {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		String a = "abcdefghijklmno";
		String c = "ab";
		boolean b = a.contains(c);
		System.out.println("b: "+b);
		boolean d = a.contentEquals("abcdefghijklmno");
		System.out.println("d: "+d);
		char[] ca = {'a','b','c','2'};
		String f = a.copyValueOf(ca);
		System.out.println(f);
		String s = new String(ca);
		System.out.println(s);
		
	}
	/**
	 * 
	 * @param ab
	 * @param ac
	 * @return
	 */
	public String aa(String ab,String ac){
		return ab;
	}

}
