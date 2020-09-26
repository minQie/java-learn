package priv.wmc.study.thrid.http.jdknative;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import lombok.extern.slf4j.Slf4j;

/**
 * 采用java原生的http请求，主要介绍一下http协议的请求头等概念，不作为工具类使用
 * 
 * @author Wang Mincong
 * @date 2019-06-25 14:49
 */
@Slf4j
public class JdkHttpUtils {
    /**
     * 连接超时时间
     */
    private static final int TIME_OUT_MILLISECONDS = 10000;
    
    public static String post(String url, String params) throws MalformedURLException, IOException {
        
        OutputStream out = null;
        BufferedReader in = null;
        HttpURLConnection conn = null;
        StringBuffer sb = new StringBuffer();
        String responseString = "";
    
        try{
            /**
             * 一、根据url创建连接对象（未真正发起连接）
             */
            conn = (HttpURLConnection) new URL(url).openConnection();
    
    		/**
			 * 二、设置连接属性（都是和http协议相关的）
			 */
			// 1、是否要使用conn.getInputStream().read()
			// conn.setDoInput(true);
			
			// 2、是否要使用conn.getOutputStream().write()（get方式不需要）
			conn.setDoOutput(true);
			
			// 3、是否缓存、校验缓存过期决定是否使用、缓存有效时间等
			// 详见：https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Caching_FAQ
			// conn.setUseCaches(false);
			conn.setRequestProperty("Cache-Control", "no-store");
			
			// 4、设置超时时间
			conn.setConnectTimeout(TIME_OUT_MILLISECONDS);
			
			// 5、设置请求方式
			conn.setRequestMethod("POST");
			
			// 6、希望接受的数据格式
			// 详见：https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Headers/Accept
			conn.setRequestProperty("Accept", "application/json");
			
			// 7、在请求中 (如POST 或 PUT)，客户端告诉服务器实际发送的数据类型（如下示例是表单的意思）
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			
			// 8、设置接受的压缩（编码）方式，这个是浏览器的行为，如果当前程序想提高效率，做了解析gzip的相关代码，可以添加该请求头
			// 这样就需要根据对应的Content-Encoding判断，服务器是否编码，采用哪种方式编码
			// 详见：https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Headers/Accept-Encoding
			// conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
			
			// 9、如字面意思（大多数时候，被忽略）
			// 详见：https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Headers/Accept-Language
			// conn.setRequestProperty("Accept-Language", "zh-CN");
			
			// 10、决定当前的事务完成后，是否会关闭网络连接。如果该值是“keep-alive”，网络连接就是持久的，不会关闭，使得对同一个服务器的请求可以继续在该连接上完成
			// 详见：https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Headers/Connection
			conn.setRequestProperty("Connection", "close");
			
			// 11、消息的长度，用十进制数字表示的八位字节的数目（一般不要手动指定，如果数值比实际小，抛出EOFException）
			// conn.setRequestProperty("Content-Length", "xxx.length");
			
			// 12、请求时，带上之前服务器返回的cookie（呼应java web中的Set-Cookie）
			// Cookie 是一个请求首部，其中含有先前由服务器通过 Set-Cookie  首部投放并存储到客户端的 HTTP cookies
			// conn.setRequestProperty("Cookie", COOKIE);
	
			// 4、将请求体的参数写出去
			out = conn.getOutputStream();
			out.write(params.getBytes());
			out.flush();
	
			// 5、发起请求
			conn.connect();
	
			// 6、获取响应数据
			String line = null;
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = in.readLine()) != null) {
				sb.append(line);
			}
			responseString = sb.toString();
	
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
			if (conn != null) {
				conn.disconnect();
			}
		}
		return responseString;
	}
}
