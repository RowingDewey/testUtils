package cn.wangzh.cmr115;

/**
 * 
 * EquityCdr
 * 
 * @author xWX180487
 * @version CMR20 2013-9-14
 * @since V100R001C01LCM020
 */
public class EquityCdr extends BaseCdr {
    private String msisdn;

    private String number;

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
	return "EquityCdr [msisdn=" + msisdn + ", number=" + number + "]";
    }
    
    
    

}
