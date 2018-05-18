package com.huizhongcf.util;

import com.alibaba.fastjson.JSON;
import java.io.IOException;
import java.io.PrintStream;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**此工具类用于合伙人向汇中网发送Http请求
 *
 */
public class HttpUtilHuiZhongWang
{
  private static final Logger logger = LoggerFactory.getLogger(HttpUtilHuiZhongWang.class);

  private static PoolingHttpClientConnectionManager connMgr = new PoolingHttpClientConnectionManager();
  private static Builder configBuilder;
  private static final int MAX_TIMEOUT = 60000;
  
  static
  {
    connMgr.setMaxTotal(100);
    connMgr.setDefaultMaxPerRoute(connMgr.getMaxTotal());
    configBuilder = RequestConfig.custom();

    configBuilder.setConnectTimeout(60000);

    configBuilder.setSocketTimeout(60000);

    configBuilder.setConnectionRequestTimeout(60000);
  }
  
  private static RequestConfig requestConfig = configBuilder.build();
  
  public static String doGet(String url, Map<String, String> params)
  {
    logger.info("@请求地址:" + url);
    String result = null;
    CloseableHttpResponse response = null;
    CloseableHttpClient httpClient = null;
    try {
      httpClient = HttpClients.createDefault();
      if (isHttps(url)) {
        httpClient = wrapClient(httpClient);
      }
      if (params != null) {
        StringBuffer param = new StringBuffer();
        int i = 0;
        for (String key : params.keySet()) {
          if (i == 0)
            param.append("?");
          else
            param.append("&");
          param.append(key).append("=").append((String)params.get(key));
          i++;
        }
        url = url + param;
      }
      logger.info("@请求参数:" + url);
      HttpGet httpget = new HttpGet(url);
      response = httpClient.execute(httpget);
      int statusCode = response.getStatusLine().getStatusCode();
      logger.info("@响应状态码：statusCode = " + statusCode);
      if (statusCode == 200) {
        HttpEntity entity = response.getEntity();
        result = EntityUtils.toString(entity, "UTF-8");
        logger.info("@响应包体：" + result);
      }
    } catch (Exception e) {
      logger.error("请求失败", e);
    } finally {
      if (response != null) {
        closeResponse(response);
      }
      if (httpClient != null) {
        closeClient(httpClient);
      }
    }
    return result;
  }

  public static String doPost(String url, Map<String, String> params)
  {
    logger.info("@请求地址:" + url);
    String httpStr = null;
    CloseableHttpClient httpClient = null;
    CloseableHttpResponse response = null;
    try {
      httpClient = HttpClients.createDefault();
      if (isHttps(url)) {
        httpClient = wrapClient(httpClient);
      }
      List nameValuePairs = new ArrayList();
      if (params != null) {
        for (String key : params.keySet()) {
          nameValuePairs.add(new BasicNameValuePair(key, (String)params.get(key)));
        }
      }
      logger.info("@请求参数:" + url);
      System.out.println("@请求参数:" + url);
      HttpPost httpPost = new HttpPost(url);
      httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
      httpPost.setConfig(requestConfig);
      response = httpClient.execute(httpPost);
      int statusCode = response.getStatusLine().getStatusCode();
      logger.info("@响应状态码：statusCode = " + statusCode);

      if (statusCode == 200) {
        HttpEntity entity = response.getEntity();
        httpStr = EntityUtils.toString(entity, "UTF-8");
        logger.info("@响应包体：" + httpStr);
        System.out.println("@响应包体：" + httpStr);
      }
    } catch (Exception e) {
      logger.error("请求失败", e);
    } finally {
      if (response != null) {
        closeResponse(response);
      }
      if (httpClient != null) {
        closeClient(httpClient);
      }
    }
    return httpStr;
  }

  public static String doPost(String url, String json, Map<String, String> heads)
  {
    logger.info("@请求地址:" + url);
    logger.info("@请求包体:" + json);
    String httpStr = null;
    CloseableHttpClient httpClient = null;
    CloseableHttpResponse response = null;
    try {
      httpClient = HttpClients.createDefault();
      if (isHttps(url)) {
        httpClient = wrapClient(httpClient);
      }
      HttpPost httpPost = new HttpPost(url);

      if (heads != null) {
        for (String key : heads.keySet()) {
          httpPost.setHeader(key, (String)heads.get(key));
        }
      }
      httpPost.setConfig(requestConfig);
      if ((json != null) && (!"".equals(json))) {
        StringEntity stringEntity = new StringEntity(json.toString(), "UTF-8");
        stringEntity.setContentEncoding("UTF-8");
        stringEntity.setContentType("application/json");
        httpPost.setEntity(stringEntity);
      }
      response = httpClient.execute(httpPost);
      int statusCode = response.getStatusLine().getStatusCode();
      logger.info("@响应状态码：statusCode = " + statusCode);
      if (statusCode == 200) {
        HttpEntity entity = response.getEntity();
        httpStr = EntityUtils.toString(entity, "UTF-8");
        logger.info("@响应包体：" + httpStr);
      }
    } catch (Exception e) {
      logger.error("请求失败", e);
    } finally {
      if (response != null) {
        closeResponse(response);
      }
      if (httpClient != null) {
        closeClient(httpClient);
      }
    }
    return httpStr;
  }

  public static String doPost(String url, String json)
  {
    return doPost(url, json, null);
  }

  public static String doInnerPost(String url, List<Map<String, String>> params, String key)
  {
    String timestamp = DateUtil.formatDateTime2();
    String sign = MD5Util.getSign(params, key, timestamp);
    Map heads = new HashMap();
    heads.put("sign", sign);
    heads.put("timestamp", timestamp);

    String body = JSON.toJSONString(params);
    return doPost(url, body, heads);
  }

  public static String doInnerPost(String url, Map<String, String> param, String key) {
    List list = new ArrayList();
    list.add(param);

    String timestamp = DateUtil.formatDateTime2();
    String sign = MD5Util.getSign(list, key, timestamp);
    Map heads = new HashMap();
    heads.put("sign", sign);
    heads.put("timestamp", timestamp);

    String body = JSON.toJSONString(list);
    return doPost(url, body, heads);
  }

  public static CloseableHttpClient wrapClient(CloseableHttpClient httpclient)
  {
    try
    {
      SSLContext ctx = SSLContext.getInstance("TLS");
      X509TrustManager tm = new X509TrustManager() {
        public X509Certificate[] getAcceptedIssuers() {
          return null;
        }

        public void checkClientTrusted(X509Certificate[] arg0, String arg1)
          throws CertificateException
        {
        }

        public void checkServerTrusted(X509Certificate[] arg0, String arg1)
          throws CertificateException
        {
        }
      };
      ctx.init(null, new TrustManager[] { tm }, null);
      SSLConnectionSocketFactory ssf = new SSLConnectionSocketFactory(ctx, NoopHostnameVerifier.INSTANCE);
      httpclient = HttpClients.custom().setSSLSocketFactory(ssf).build();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return httpclient;
  }

  public static boolean isHttps(String url)
  {
    String scheme = url.substring(0, url.indexOf(":"));
    if ("HTTPS".equals(scheme.toUpperCase())) {
      return true;
    }
    return false;
  }

  public static void closeClient(CloseableHttpClient httpClient)
  {
    if (httpClient != null)
      try {
        httpClient.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
  }

  public static void closeResponse(CloseableHttpResponse response)
  {
    if (response != null)
      try {
        response.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
  }

  public static void main(String[] args)
  {
    List list = new ArrayList();
    Map param1 = new HashMap();

    param1.put("id", "111");
    param1.put("name", "222222");

    Map param2 = new HashMap();

    param2.put("ddd", "111");
    param2.put("naaaame", "222222");

    list.add(param1);
    list.add(param2);

    String str = doInnerPost("http://localhost:8080/financial-partner-api/partner/find", list, "368a72dd1e9443728d186bfcc046b402");
    System.out.println(str);
  }


}