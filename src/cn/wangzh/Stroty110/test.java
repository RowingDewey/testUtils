package cn.wangzh.Stroty110;

public class test {
	public static void main(String[] args) {
		//System.out.println(22222);
		String ip = "127.210.230.110";
		String[] ipArray = ip.split("\\.");
        StringBuilder checkIp = new StringBuilder();
        for(String str : ipArray)
        {
        	//System.out.println(111111);
            if(str.length() == 2)
            {
            	//System.out.println(str.length());
                checkIp = checkIp.append("0").append(str);
            }
            else if(str.length() == 1)
            {
            	//System.out.println(str.length());
                checkIp = checkIp.append("00").append(str);
            }
            else
            {
            	//System.out.println(str.length());
                checkIp = checkIp.append(str);
            }
            
            //System.out.println("1:"+checkIp.toString());
        }
        System.out.println("2:"+checkIp.toString());
	}
}
