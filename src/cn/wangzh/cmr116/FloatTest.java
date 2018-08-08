package cn.wangzh.cmr116;

public class FloatTest {
    public static void main(String[] args) {
	
	float f = 0.4f;
	long l = round(f);
	System.out.println("四舍五入:" + l);
    }
    
    
    /**
     * 
     * 四舍五入
     * 
     * @author cKF74481
     * @param price 浮点型原价
     * @return 四舍五入后的价格
     */
    public static int round(float price)
    {
        return Math.round(price);
    }
}
