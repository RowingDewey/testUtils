package cn.wangzh.demo;


public class Demo10 {
	public static void main(String[] args) throws Exception {
		Model1 model = new Model1();
		String str = String.valueOf(model.getA());
		boolean flag =( model.getA() == model.getB());
		System.out.println("a:" + model.getA());
		System.out.println("str:" + str);
		System.out.println("flag:" + flag);
		
		StringBuffer s = new StringBuffer();
		s.append("112");
		s.append("wawa waw ");
		System.out.println("buffer:" + s);
		
		String str1 = "return_aaa";
		
		System.out.println(java.net.URLEncoder.encode("", "utf-8"));
		
		
	}

}

