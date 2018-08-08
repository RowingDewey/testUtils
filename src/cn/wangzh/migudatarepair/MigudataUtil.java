package cn.wangzh.migudatarepair;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

public class MigudataUtil extends Thread
{
    
    private String path;
    
    private String savepath;
    
    private int limit;
    
    public MigudataUtil(String path, String savepath, int limit)
    {
        this.path = path;
        this.savepath = savepath;
        this.limit = limit;
    }
    
    @Override
    public void run()
    {
        // TODO Auto-generated method stub
        File sf = new File(savepath);
        if (!sf.exists())
        {
            try
            {
                sf.createNewFile();
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        File file = new File(path);
        File[] tempList = file.listFiles();
        System.out.println("该目录下文件个数" + this.getName() + ":" + tempList.length);
        FileOutputStream out = null;
        try
        {
            out = new FileOutputStream(sf);
        }
        catch (FileNotFoundException e1)
        {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        if (out == null)
        {
            return;
        }
        
        for (int i = 0; i < tempList.length; i++)
        {
            if (tempList[i].isFile())
            {
                InputStreamReader read = null;
                try
                {
                    read = new InputStreamReader(new FileInputStream(tempList[i]), "GB2312");
                }
                catch (UnsupportedEncodingException e1)
                {
                    e1.printStackTrace();
                }
                catch (FileNotFoundException e1)
                {
                    e1.printStackTrace();
                } // 考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                long allNum = 0;
                long successNum = 0;
                long webNum = 0;
                long appNum = 0;
                long errorNum = 0;
                try
                {
                    while ((lineTxt = bufferedReader.readLine()) != null)
                    {
                        if (lineTxt != null && !"".equals(lineTxt.trim()))
                        {
                            allNum++;
                            
                            String[] tempParam = lineTxt.split("#");
                            String orderId = tempParam[0];
                            String tranid = tempParam[1];
                            String mobile = tempParam[2];
                            String time = tempParam[3];
                            /*
                             * String code=tempParam[4]; String codedesc=tempParam[5];
                             */
                            String ext = "";
                            if (tempParam.length > 6)
                            {
                                ext = tempParam[6];
                            }
                            String orderType = orderId.substring(0, 3);
                            String url = "";
                            String reqxml = "";
                            if ("020".equals(orderType))
                            {
                                url = "http://211.140.17.112:8585/PROXY/sunshineSdkPay/sunshineSdkPayCallBack";
                                reqxml = "<?xml version='1.0' encoding='UTF-8'?>"
                                + "<ChargeNotificationRequest>"
                                + "<Header>"
                                + "<MsgType>1204</MsgType>"
                                + "<ActionCode>0</ActionCode>"
                                + "<TransactionID>01220160617104252000605</TransactionID>"
                                + "<Version>0001</Version>"
                                + "<ProcessTime>" + time + "</ProcessTime>"
                                + "</Header>"
                                + "<Body>"
                                + "<PHONENUMBER>" + mobile + "</PHONENUMBER>"
                                + "<ORDER_ID>" + orderId + "</ORDER_ID>"
                                + "<TradeSession>" + tranid + "</TradeSession>"
                                + "<ResultCode>00000</ResultCode>"
                                + "<ResultDesc>success</ResultDesc>"
                                + "<extendAttr>" + ext + "</extendAttr>"
                                + "</Body>"
                                + "</ChargeNotificationRequest>";
                                
                                appNum++;
                            }
                            else if ("022".equals(orderType))
                            {
                                url = "http://211.140.17.112:8585/PROXY/webSdkPayCallBackController/webSdkPayCallBack";
                                reqxml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                                + "<ChargeNotificationRequest>"
                                + "<Header>"
                                + "<MsgType></MsgType>"
                                + "<ActionCode>0</ActionCode>"
                                + "<TransactionID>01220160256111249000001</TransactionID>"
                                + "<Version>0001</Version>"
                                + "<ProcessTime>" + time + "</ProcessTime>"
                                + "</Header>"
                                + "<Body>"
                                + "<ORDER_ID>" + orderId + "</ORDER_ID>"
                                + "<TradeSession>" + tranid + "</TradeSession>"
                                + "<PHONENUMBER>" + mobile + "</PHONENUMBER>"
                                + "<ResultCode>00000</ResultCode>"
                                + "<ResultDesc>success</ResultDesc>"
                                + "<extendAttr>" + ext + "</extendAttr>"
                                + "</Body>"
                                + "</ChargeNotificationRequest>";
                                
                                webNum++;
                            }
                            else
                            {
                                continue;
                            }
                            String response = "";
                            try
                            {
                                response = HttpClientUtil.post(url, reqxml, "UTF-8");
                            }
                            catch (Exception e1)
                            {
//                                writeError(out, lineTxt);
//                                writeError(out, "\r\n");
//                                errorNum++;
//                                continue;
                                //e1.printStackTrace();
                                //String erroMSG = getErrorInfoFromException(e1);
                                //System.out.println(tempList[i].getName() + "-->" + lineTxt + "; erroMSG=" + erroMSG);
                            }
                            try
                            {
                                Thread.sleep(limit);
                                // System.out.println(this.getName() + ": sleep 10");
                            }
                            catch (InterruptedException e)
                            {
                                System.out.println("sleep is error!");
                            }
                            
                            if (response.contains("<ResultCode>00000</ResultCode>"))
                            {
                                successNum++;
                            }
                            else
                            {
                                writeError(out, lineTxt);
                                writeError(out, "\r\n");
                                errorNum++;
                            }
                        }
                    }
                }
                catch (IOException e1)
                {
                    writeError(out, lineTxt);
                    writeError(out, "\r\n");
                    e1.printStackTrace();
                    System.out.println(this.getName() + "io is error!");
                }
                try
                {
                    read.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                System.out.println(tempList[i].getName() + "已完成;成功=" + successNum + "; 所有=" + allNum + "; webNum=" + webNum + "; appNum="
                    + appNum + "; errorNum=" + errorNum);
            }
        }
        try
        {
            out.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    private void writeError(FileOutputStream out, String txt)
    {
        try
        {
            out.write(txt.getBytes());
        }
        catch (IOException e)
        {
            System.out.println("writeError is error!");
        }
    }
    
    public static String getErrorInfoFromException(Exception e)
    {
        try
        {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            return "\r\n" + sw.toString() + "\r\n";
        }
        catch (Exception e2)
        {
            return "bad getErrorInfoFromException";
        }
    }
}
