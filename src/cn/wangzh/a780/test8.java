package cn.wangzh.a780;

public class test8 {
    private static final int[][] SEQ_CTLLEVEL = new int[][] { {1, 1, 1, 1}, {1, 1, 1, 0}, {1, 1, 0, 1}, {1, 0, 1, 1},
        {0, 1, 1, 1}, {1, 1, 0, 0}, {1, 0, 1, 0}, {1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 0, 1}, {0, 0, 1, 1}, {1, 0, 0, 0},
        {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
    
    private static final String[] KEY_PREFIXS = {"3:", "", "2:", "1:", "0:", "99:"};
    
	public static void main(String[] args) {

		for(int i=1;i<=6;i++)
		{
			getkey(i);
		}
		
	}

	public static void getkey(int count)
	{
		String hierarchKey=null;
		
		for (int[] ss : SEQ_CTLLEVEL)
        {
            // 管控级别key
            hierarchKey =
               buildKey("_",
                    1 == ss[0] ? "0000" : "-1",//channelid
                    1 == ss[1] ? "-1" : "-1", //cpid
                    1 == ss[2] ? "798606871" : "-1",//cata
                    1 == ss[2] ? "-1" : "-1",//bookid
                    1 == ss[3] ? "571" : "000"); // provin
            
            System.out.println("hierarchKey"+ KEY_PREFIXS[count - 1] +"  =  " + KEY_PREFIXS[count - 1] + hierarchKey);
        }
		
	}
	public static String buildKey(String separator, String... values) {

		if ((null == values) || null == separator) {
			return "";
		}
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < values.length; i++) {
			if (i == values.length - 1) {
				builder.append(values[i]);
			} else {
				builder.append(values[i]).append(separator);
			}
		}
		return builder.toString();
	}
}
