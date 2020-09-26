package priv.wmc.study.thrid.http.okhttp;

import java.io.IOException;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 要基于连接池
 * 从postman了解到，OkHttp，一款流行的http工具（需要引入okhttp）
 * 
 * @author Wang Mincong
 * @date 2019-06-25 14:49
 */
@Slf4j
public class OkHttpUtils {

    /**
     * 简单的Get请求示例
     */
    public void simpleGetExample() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                  .build();

        // url、param -> url
        HttpUrl httpUrl = HttpUrl.parse("http://60.205.183.30:8080/onepig/electricity/ElectricityAction.action")
                .newBuilder()
                .addQueryParameter("buildingName", "5A")
            	.addQueryParameter("roomName", "207")
				.build();
		
		// header -> request
		Request request = new Request.Builder()
		 	.url(httpUrl)
		 	.get()
			.addHeader("Content-Type", "application/x-www-form-urlencoded")
			.addHeader("cache-control", "no-cache")
			.build();
		
		// async request
//		client.newCall(request).enqueue(new Callback() {
//			
//			// 请求失败
//			@Override
//			public void onFailure(Call call, IOException e) {
//				log.info("请求成功!");
//			}
//
//			// 请求成功
//			@Override
//			public void onResponse(Call call, Response response) throws IOException {
//				ResponseBody responseBody = response.body();
//              // 空校验
//              if (responseBody == null) {
//                  onFailure(call, new IOException("请求失败：无响应"));
//                  return;
//              }
//              String resultString = responseBody.string();
//              if (StringUtils.isBlank(resultString)) {
//                  onFailure(call, new IOException("请求失败：空响应"));
//                  return;
//              }
//                
//              // 成功
//				log.info(response.toString());
//			}
//			
//		});
		
		// sync request
		Response response;
		try {
			response = client.newCall(request).execute();
			if (!response.isSuccessful()) {
				// 失败
				throw new IOException("请求失败!");
			}
			// 成功
			log.info(response.toString());
		} catch (IOException e) {
			// 失败
			e.printStackTrace();
		}
	}
	
	/**
	 * 同步post请求：json参数、json响应
	 */
	public static void postExample(Object bodyParam, Class<?> resultclass) {
		// url
        HttpUrl httpUrl = HttpUrl.parse("http://127.0.0.1:8080/api/def/v1/workshop");

        // request body
        String requestJsonString = JSON.toJSONString(bodyParam);
        RequestBody requestBody = RequestBody.create(requestJsonString, MediaType.parse("application/json; charset=utf-8"));

        // request
        Request request = new Request
                .Builder()
                .url(httpUrl)
//                .post(requestBody)
                .method("POST", requestBody)
                .addHeader("Content-Type", "application/json")
                .addHeader("X-User-Token", "kYxvKmgjebcm.2.b59a42947a4440c92e2c6d117060fcd8")
                .build();

        
        Response response;
		try {
			// sync request
			response = new OkHttpClient().newCall(request).execute();
			// analysis result：ResponseBody.string方法会读取响应资源，并关闭资源 - 只能调用一次
			String resultString = response.body().string();
			log.info(resultString);
			// fail
			if (!response.isSuccessful()) {
				throw new IOException("请求失败!");
			}
			// success -> deserialize response
			JSON.parseObject(resultString, resultclass);
		} catch (IOException e) {
			// fail
			e.printStackTrace();
		}
	}
	
}
