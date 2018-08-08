package cn.wangzh.a780;

public class test9 {
	public static void main(String[] args) {
      String str = "csp1212";
      System.out.println("to Up:" + getTrim(str.toUpperCase(),"-1"));
	}
	
    public static String getTrim(String str, String def)
    {
        if (str == null)
        {
            return def;
        }
        String t = str.trim();
        return (t.length() == 0) ? def : t;
    }
}
