package cn.wangzh.xml.response;

import cn.wangzh.xml.Person;

import java.util.List;


public class SecuritySignResponse
{
    private String resultCode;
    
    private String resultMsg;
    
    private String signResult;
    
    private List<Person> persons;
    
    public String getResultCode()
    {
        return resultCode;
    }
    
    public List<Person> getPersons()
    {
        return persons;
    }
    
    public void setPersons(List<Person> persons)
    {
        this.persons = persons;
    }
    
    public void setResultCode(String resultCode)
    {
        this.resultCode = resultCode;
    }
    
    public String getResultMsg()
    {
        return resultMsg;
    }
    
    public void setResultMsg(String resultMsg)
    {
        this.resultMsg = resultMsg;
    }
    
    public String getSignResult()
    {
        return signResult;
    }
    
    public void setSignResult(String signResult)
    {
        this.signResult = signResult;
    }
    
    @Override
    public String toString()
    {
        return "SecuritySignResponse [resultCode=" + resultCode + ", resultMsg=" + resultMsg + ", signResult="
            + signResult + ", persons=" + persons + "]";
    }
}
