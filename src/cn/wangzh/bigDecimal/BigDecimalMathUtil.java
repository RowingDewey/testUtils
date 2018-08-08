package cn.wangzh.bigDecimal;

import java.math.BigDecimal;

public class BigDecimalMathUtil
{
    public static void main(String[] args)
    {
        String vipPrice = "10";
        String ticket = "2";
        
        String price = addZeroForNum(vipPrice, ticket);
        System.out.println("Price = " + price);
    }
    
    /**
     * 
     * 分转为元
     *
     * @author wangzhuohui
     * @param fenPrice
     * @return
     */
    public static String changeFentoYuan(String fenPrice)
    {
        String yuanPrice = "0.00";
        try
        {
            Integer.parseInt(fenPrice);
        }
        catch (Exception e)
        {
            fenPrice = "0";
        }
        fenPrice = String.valueOf(Math.abs(Integer.parseInt(fenPrice)));
        int length = fenPrice.length();
        
        switch (length)
        {
            case 1:
                yuanPrice = "0.0" + fenPrice;
                break;
            case 2:
                yuanPrice = new StringBuilder().append("0.").append(fenPrice).toString();
                break;
            default:
                yuanPrice = new StringBuilder().append(fenPrice.substring(0, length - 2))
                    .append(".")
                    .append(fenPrice.substring(length - 2))
                    .toString();
                break;
        }
        
        return yuanPrice;
    }
    
    /**
     * 
     * 价格计算防止精度丢失(价格单位：分)
     *
     * @author wangzhuohui
     * @param actualPrice0
     * @param actualPrice1 actualPrice0 - actualPrice1
     * @return
     */
    public static String addZeroForNum(String actualPrice0, String actualPrice1)
    {
        double actualPrice =
            Double.parseDouble(changeFentoYuan(actualPrice0)) - Double.parseDouble(changeFentoYuan(actualPrice1));
        // 表示四舍五入
        int roundingMode = 4;
        
        BigDecimal bd = new BigDecimal(String.valueOf(actualPrice));
        
        bd = bd.setScale(2, roundingMode);
        
        int price = Integer.parseInt(String.valueOf(mul(bd.floatValue(), 100f)).split("\\.")[0]);
        
        return changeFentoYuan(String.valueOf(price));
    }
    
    /**
     * 
     * 精度计算
     *
     * @author wangzhuohui
     * @param v1
     * @param v2
     * @return
     */
    public static float mul(float v1, float v2)
    {
        BigDecimal b1 = new BigDecimal(Float.toString(v1));
        BigDecimal b2 = new BigDecimal(Float.toString(v2));
        return b1.multiply(b2).floatValue();
    }
}