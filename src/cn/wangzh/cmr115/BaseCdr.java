package cn.wangzh.cmr115;




/**
 * 生成报表抽象类
 * 
 * @author 吴飞00106856
 * @version [1.0, 2009-5-10]
 * @see [相关类/方法]
 * @since [iRead/Server1.0]
 */
public class BaseCdr
{

    protected String msisdn;
    
    protected String number;
    
    
    public String getMsisdn() {
        return msisdn;
    }


    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }


    public String getNumber() {
        return number;
    }


    public void setNumber(String number) {
        this.number = number;
    }


    @Override
    public String toString() {
	return "BaseCdr [msisdn=" + msisdn + ", number=" + number + "]";
    }


    
    

}
