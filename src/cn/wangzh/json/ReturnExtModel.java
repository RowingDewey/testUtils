package cn.wangzh.json;

public class ReturnExtModel
{
    /**
     * header
     */
    private String header;
    
    /**
     * body
     */
    private String body;

    public String getHeader()
    {
        return header;
    }

    public void setHeader(String header)
    {
        this.header = header;
    }

    public String getBody()
    {
        return body;
    }

    public void setBody(String body)
    {
        this.body = body;
    }

    @Override
    public String toString()
    {
        return "ReturnExtModel [header=" + header + ", body=" + body + "]";
    }
    

}
