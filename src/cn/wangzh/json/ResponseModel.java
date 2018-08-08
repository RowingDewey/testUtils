package cn.wangzh.json;

public class ResponseModel 
{
    /**
     * TODO 添加字段注释
     */
    private static final long serialVersionUID = 1L;

    /**
     * 交易流水
     */
    private String transId;
    
    /**
     * 手机号码
     */
    private String phoneNumber;
    
    
    /**
     * 请求时间
     */
    private String processTime;
    
    
    /**
     * 返回码
     */
    private String returnCode;
     

    /**
     * 返回码对应的描述
     */
    private String returnMsg;
    
    /**
     * 返回扩展字段
     */
    private String returnExt;

    public String getTransId()
    {
        return transId;
    }

    public void setTransId(String transId)
    {
        this.transId = transId;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getProcessTime()
    {
        return processTime;
    }

    public void setProcessTime(String processTime)
    {
        this.processTime = processTime;
    }

    public String getReturnCode()
    {
        return returnCode;
    }

    public void setReturnCode(String returnCode)
    {
        this.returnCode = returnCode;
    }

    public String getReturnMsg()
    {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg)
    {
        this.returnMsg = returnMsg;
    }

    public String getReturnExt()
    {
        return returnExt;
    }

    public void setReturnExt(String returnExt)
    {
        this.returnExt = returnExt;
    }

    @Override
    public String toString()
    {
        return "ResponseModel [transId=" + transId + ", phoneNumber=" + phoneNumber + ", processTime=" + processTime
            + ", returnCode=" + returnCode + ", returnMsg=" + returnMsg + ",returnExt=" + returnExt + "]";
    }
      
}
