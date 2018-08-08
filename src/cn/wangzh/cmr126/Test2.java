package cn.wangzh.cmr126;

public class Test2
{
    public static void main(String[] args)
    {
//        StringBuilder str = new StringBuilder();
//        str.append("12345").append(":");
//        str.append("").append(":");
//        str.append("abc");
//        
//        String s = new String(str);
//        
//        String[] a = s.split(":");
//        
//        for(String ss : a)
//        {
//            System.out.println(ss);
//        }
        
        BatchChaptersCalculateRsp resp = new BatchChaptersCalculateRsp();
        resp.setBookid("123");
        resp.setBookname("abc");
        
        StringBuilder str = new StringBuilder();
        str.append(resp.getBookid()).append(":");
        str.append(resp.getChapterid()).append(":");
        str.append(resp.getBookname());
        
        String s = new String(str);
        String[] a = s.split(":");
        for(String ss : a)
          {
              System.out.println(ss);
          }
    }
}
