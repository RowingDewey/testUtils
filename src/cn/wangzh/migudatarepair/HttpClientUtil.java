package cn.wangzh.migudatarepair;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 * TODO 添加类的描述
 * 
 * @author pangcongcong
 * @version C10 2015-12-10
 * @since SDP V300R003C10
 */
public class HttpClientUtil
{
    
    private static final Log log = LogFactory.getLog(HttpClientUtil.class);
    
    /**
     * 发送 Post请求 ,指定参数名
     * 
     * @param url
     * @param reqXml
     * @return
     */
    public static String post(String url, List<NameValuePair> params, String encoding)
    {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 返回的response
        String body = null;
        try
        {
            // post请求
            HttpPost httpPost = new HttpPost(url);
            // 设置参数和编码
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, encoding);
            httpPost.setEntity(formEntity);
            // 发送post请求
            HttpResponse resp = httpClient.execute(httpPost);
            HttpEntity entity = resp.getEntity();
            // 将响应体转成字符串
            body = EntityUtils.toString(entity, encoding).trim();
            httpPost.abort();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            try
            {
                httpClient.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return body;
    }
    
    public static String postjson(String url, String reqXml, String encoding)
        throws Exception
    {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 返回的response
        String body = null;
        try
        {
            HttpPost httppost = new HttpPost(url);
            StringEntity myEntity = new StringEntity(reqXml, encoding);
            httppost.addHeader("Content-Type", "application/json");
            httppost.setEntity(myEntity);
            // 发送post请求
            HttpResponse response = httpClient.execute(httppost);
            HttpEntity resEntity = response.getEntity();
            // 将响应体转成字符串
            body = EntityUtils.toString(resEntity, encoding).trim();
        }
        catch (ClientProtocolException e)
        {
            log.error("HTTPClient post.ClientProtocolException", e);
            throw e;
        }
        catch (IOException e)
        {
            log.error("HTTPClient post.IOException", e);
            throw e;
        }
        finally
        {
            try
            {
                httpClient.close();
            }
            catch (IOException e)
            {
                log.error("HTTPClient post. httpClient.close() IOException", e);
            }
        }
        
        return body;
    }
    
    /**
     * 发送 Post请求 ,未指定参数名
     * 
     * @param url
     * @param reqXml
     * @param encoding
     * @return
     * @throws Exception
     */
    public static String post(String url, String reqXml, String encoding)
        throws Exception
    {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 返回的response
        String body = null;
        try
        {
            HttpPost httppost = new HttpPost(url);
            StringEntity myEntity = new StringEntity(reqXml, encoding);
            httppost.addHeader("Content-Type", "text/xml");
            httppost.setEntity(myEntity);
            // 发送post请求
            HttpResponse response = httpClient.execute(httppost);
            HttpEntity resEntity = response.getEntity();
            // 将响应体转成字符串
            body = EntityUtils.toString(resEntity, encoding).trim();
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            try
            {
                httpClient.close();
            }
            catch (Exception e)
            {
                throw e;
            }
        }
        
        return body;
    }
    
    public static String post(String url, String reqXml, String encoding, Map<String, String> headers)
        throws Exception
    {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 返回的response
        String body = null;
        try
        {
            HttpPost httppost = new HttpPost(url);
            StringEntity myEntity = new StringEntity(reqXml, encoding);
            httppost.addHeader("Content-Type", "text/xml");
            // 放入请求头信息
            for (String key : headers.keySet())
            {
                httppost.addHeader(key, headers.get(key));
            }
            httppost.setEntity(myEntity);
            // 发送post请求
            HttpResponse response = httpClient.execute(httppost);
            HttpEntity resEntity = response.getEntity();
            // 将响应体转成字符串
            body = EntityUtils.toString(resEntity, encoding).trim();
        }
        catch (ClientProtocolException e)
        {
            // log.error("HTTPClient post.ClientProtocolException",e);
            throw e;
        }
        catch (IOException e)
        {
            // log.error("HTTPClient post.IOException",e);
            throw e;
        }
        finally
        {
            try
            {
                httpClient.close();
            }
            catch (IOException e)
            {
                // log.error("HTTPClient post. httpClient.close() IOException",e);
            }
        }
        
        return body;
    }
}
