package cn.wangzh.demo;

public class demo08 {
	public static void main(String[] args) {
		String url = "return_url=cmread://cmread.com/getResultFromAlipay.do?url=http://www.cmread.com";
		String[] a = url.split("\\=",2);
		System.out.println(a[0]);
		System.out.println(a[1]);
		
		
	}

}
