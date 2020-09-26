package priv.wmc.study.thrid.http.httpclient;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import priv.wmc.study.thrid.http.StaticConstant;

/**
 * 使用HttpClient发送post和get请求的工具类（需要引入httpclient、httpcore、commons-logging）
 *
 * @author Wang Mincong
 * @date 2019-06-25 14:49
 */
@Slf4j
public final class HttpClientUtils {

    private HttpClientUtils() {}

    /**
     * get请求
     * @param url 请求地址（不能带参数）
     * @param parameterMap 地址后面的参数
     * @return
     * @throws IOException
     */
    public static String get(String url, Map<String, String> parameterMap) throws IOException {
        return request(url, parameterMap, null);
    }

    /**
     * post请求
     * @param url 请求地址（不能带参数）
     * @param bodyParameterMap 请求体参数
     * @return
     * @throws IOException
     */
    public static String post(String url, Map<String, String> bodyParameterMap) throws IOException {
        return request(url, null, bodyParameterMap);
    }

    /**
     * 核心请求方法
     * @param url
     * @param parameterMap get请求的参数
     * @param bodyParameterMap post请求的参数
     * @return
     * @throws IOException
     */
    public static String request(String url, Map<String, String> parameterMap, Map<String, String> bodyParameterMap) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        if (parameterMap != null) {
            String paramters = EntityUtils.toString(mapToEntity(parameterMap));
            url += ("?" + paramters);
        }
        HttpPost httpPost = new HttpPost(url);

        // 一、设置请求的基本配置
        RequestConfig defaultRequestConfig = RequestConfig.custom()
            // 读取数据的超时时间
            .setSocketTimeout(StaticConstant.SOCKET_TIMEOUT)
            // 实际连接的超时时间
            .setConnectTimeout(StaticConstant.CONNECTION_TIMEOUT)
            // 从连接池获取连接的超时时间
            .setConnectionRequestTimeout(StaticConstant.CONNECTION_REQUEST_TIMEOUT)
            // 是否将内容进行压缩（编码）后传输（需要配合Content-Encoding请求头使用）
            .setContentCompressionEnabled(false)
            .build();
        httpPost.setConfig(defaultRequestConfig);

        // 二、设置请求头
        // 1、设置提交的参数类型
        httpPost.setHeader("Content-type","application/x-www-form-urlencoded; charset=utf-8");
        // HttpEntity.setContentType(ContentType.APPLICATION_JSON.withCharset(Charset.forName("UTF-8")).toString());
        // 2、设置接受的数据类型
        httpPost.setHeader("Accept", "application/json");
        // 3、不使用任何缓存
        httpPost.setHeader("Cache-Control", "no-store");
        // 4、不需要长连接
        httpPost.setHeader("Connection", "close");

        // 三、设置请求体参数
        if (bodyParameterMap != null) {
            // UrlEncodedFormEntity的作用可以查看源码的注释
            httpPost.setEntity(mapToEntity(bodyParameterMap));
        }

        // 四、发起请求
        CloseableHttpResponse response = null;
        String resultString = null;
        try {
            response = client.execute(httpPost);
            // 1、判断响应码
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                log.info("请求失败，响应码:" + response.getStatusLine());
            }
            // 2、解析响应数据
            HttpEntity httpEntity = response.getEntity();
            resultString = EntityUtils.toString(httpEntity, StandardCharsets.UTF_8);
            // 关闭InputStream
            EntityUtils.consume(httpEntity);
        } finally {
            // 五、将连接归还连接池
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                log.info("归还连接失败!");
                e.printStackTrace();
            }
        }
        return resultString;
    }

    /**
     * Map<String, String> -> StringEntity
     * @param parameterMap
     */
    private static HttpEntity mapToEntity(Map<String, String> parameterMap) {
        List<NameValuePair> parameterList = new ArrayList<>();
        for (Map.Entry<String, String> entry : parameterMap.entrySet()) {
            parameterList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        return new UrlEncodedFormEntity(parameterList, StandardCharsets.UTF_8);
    }

}
