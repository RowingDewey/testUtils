package cn.wangzh.cmr118;

public class Test003 {
    public static void main(String[] args) {
         String str = "<Response><forumIdCnt>1</forumIdCnt><forumIdList><forumId>9527630</forumId></forumIdList></Response>";
         
         String fId = str.substring(str.indexOf("<forumId>") + 9, str.indexOf("</forumId>"));
         System.out.println("fId=" + fId);
         
    }
}
