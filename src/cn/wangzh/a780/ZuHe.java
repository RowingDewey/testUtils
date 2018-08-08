package cn.wangzh.a780;

import java.util.HashSet;
import java.util.Iterator;

public class ZuHe {
    private static final int[][] SUN_SEQ_CTLLEVEL = new int[][] { {1, 1, 1, 1, 1}, {1, 1, 1, 1, 0}, {1, 1, 1, 0, 1},
        {1, 1, 1, 0, 0}, {1, 1, 0, 1, 1}, {1, 1, 0, 1, 0}, {1, 1, 0, 0, 1}, {1, 1, 0, 0, 0}, {1, 0, 1, 1, 1},
        {1, 0, 1, 1, 0}, {1, 0, 1, 0, 1}, {1, 0, 1, 0, 0}, {1, 0, 0, 1, 1}, {1, 0, 0, 1, 0}, {1, 0, 0, 0, 1},
        {1, 0, 0, 0, 0}};
    
	public static void main(String[] args) {

        HashSet<String> keys = new HashSet<String>();
        // bookid productId同时存在时存两个
        for (int[] keyType : SUN_SEQ_CTLLEVEL)
        {
            String key =
                buildKey(1 == keyType[0] ? "2" : "-1",
                        1 == keyType[1] ? "2" : "-1",
                        1 == keyType[2] ? "2" : "-1",
                        1 == keyType[3] ? "2" : "-1",
                        1 == keyType[4] ? "2" : "-1");
            keys.add(key);
        }
        System.out.println("keys.size=" + keys.size());
        Iterator<String> keyIt = keys.iterator();
        while (keyIt.hasNext())
        {
            String key = keyIt.next();
            System.out.println("key=" + key);
        }
        
        
	}
    private static String buildKey(String type, String channelId, String cpId, String productId_bookId,String provinceId)
    {
        StringBuilder strb = new StringBuilder();
        strb.append(type);
        strb.append("_");
        strb.append(channelId);
        strb.append("_");
        strb.append(cpId);
        strb.append("_");
        strb.append(productId_bookId);
        strb.append("_");
        strb.append(provinceId);
        
        return strb.toString();
    }
}
