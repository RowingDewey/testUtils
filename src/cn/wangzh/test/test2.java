package cn.wangzh.test;

public class test2 {
	 public static void main(String[] args){   
		 int i = 0 ;  
		 for(foo('A');foo('B')&&i<3;foo('C'))
		 {   
			 i++ ; 
			 foo('D') ; 
			 }
		 } 
	 public static boolean foo(char c)
	 { 
		 System.out.print(c + " ");
		 return true ; 
		 } 
}
