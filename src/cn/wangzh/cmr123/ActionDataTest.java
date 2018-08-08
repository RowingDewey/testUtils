package cn.wangzh.cmr123;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class ActionDataTest
{
    public static void main(String[] args)
    {
        analysisData("D://huadanAnalysis/huadan", "D://huadanAnalysis/analysisData.txt");
    }
    
    
    
    public static void analysisData(String path, String savepath)
    {
        
        // 得到分析后文件
        File sf = new File(savepath);
        if (!sf.exists())
        {
            try
            {
                sf.createNewFile();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        
        // 读取数据分析
        File file = new File(path);
        File[] tempList = file.listFiles();
        System.out.println("该目录下文件个数=" + tempList.length);
        FileOutputStream out = null;
        try
        {
            out = new FileOutputStream(sf);
        }
        catch (FileNotFoundException e1)
        {
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
                long errorNum = 0;
                try
                {
                    while ((lineTxt = bufferedReader.readLine()) != null)
                    {
                        if (lineTxt != null && !"".equals(lineTxt.trim()))
                        {
                            // 总数++
                            allNum++;
                            String[] tempParam = lineTxt.split("\\|");
                            if(tempParam.length > 17)
                            {
                                String action = tempParam[1];
                                String requestTime = tempParam[3];
                                String responseTime = tempParam[4];
                                String castTime = tempParam[5];
                                String useagent = tempParam[6];
                                String responseCode = tempParam[14];
                                String phoneNum = tempParam[17];
                                if("2004".equals(responseCode))
                                {
                                    // 成功数++
                                    successNum ++;
                                    
                                    StringBuilder strBulid = new StringBuilder();
                                    strBulid.append(action);
                                    strBulid.append("#");
                                    strBulid.append(responseCode);
                                    strBulid.append("#");
                                    strBulid.append(useagent);
                                    strBulid.append("#");
                                    strBulid.append(requestTime);
                                    strBulid.append("#");
                                    strBulid.append(responseTime);
                                    strBulid.append("#");
                                    strBulid.append(castTime);
                                    strBulid.append("#");
                                    strBulid.append(phoneNum);
                                    
                                    writeAnalysis(out, strBulid.toString());
                                    writeAnalysis(out, "\r\n");
                                }
                                else
                                {
                                    // 失败数++
                                    errorNum ++;
                                }
                                
                            }
                            else
                            {
                                // 失败数++
                                errorNum ++;
                            }
                        }
                    }
                }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
                try
                {
                    read.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                
                System.out.println(tempList[i].getName() + "已完成; 分析总数=" + allNum + "; 分析成功结果数=" + successNum + "; 分析失败结果数=" + errorNum);
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
    
    private static void writeAnalysis(FileOutputStream out, String txt)
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
    
}
