package cn.wangzh.cmr126;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * 连载章节批量订购批价请求类
 *
 * @author wangzhuohui
 * @version CMR126 2017年4月13日
 * @since SDP V300R003C10
 */
public class BatchChaptersCalculateRsp implements Serializable
{
    
    /**
     * TODO 添加字段注释
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 是否订购
     */
    private boolean isOrdered;
    
    private String bookid;
    
    private String chapterid;
    
    private String bookname;
    
    public String getBookid()
    {
        return bookid;
    }
    
    public void setBookid(String bookid)
    {
        this.bookid = bookid;
    }
    
    public String getChapterid()
    {
        return chapterid;
    }
    
    public void setChapterid(String chapterid)
    {
        this.chapterid = chapterid;
    }
    
    public String getBookname()
    {
        return bookname;
    }
    
    public void setBookname(String bookname)
    {
        this.bookname = bookname;
    }
    
    /**
     * 支付列表
     */
    private List<String> payInfoList;
    
    // public boolean getIsOrdered()
    // {
    // return isOrdered;
    // }
    //
    // public void setIsOrdered(boolean isOrdered)
    // {
    // this.isOrdered = isOrdered;
    // }
    
    public boolean isOrdered()
    {
        return isOrdered;
    }
    
    public void setOrdered(boolean isOrdered)
    {
        this.isOrdered = isOrdered;
    }
    
    public List<String> getPayInfoList()
    {
        return payInfoList;
    }
    
    public void setPayInfoList(List<String> payInfoList)
    {
        this.payInfoList = payInfoList;
    }
    
    @Override
    public String toString()
    {
        return "BatchChaptersCalculateRsp [isOrdered=" + isOrdered + ", bookid=" + bookid + ", chapterid=" + chapterid
            + ", bookname=" + bookname + ", payInfoList=" + payInfoList + "]";
    }
    
}
