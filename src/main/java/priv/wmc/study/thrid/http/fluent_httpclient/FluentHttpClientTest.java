package priv.wmc.study.thrid.http.fluent_httpclient;

import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.junit.Test;

/**
 * @author Wang Mincong
 * @date 2020-07-13 15:31:44
 */
public class FluentHttpClientTest {

    @Test
    public void test() {
        // more see: https://blog.csdn.net/vector_yi/article/details/24298629
    }

    public void postJson() throws IOException {
        String url = "";

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("mode","delete");
        jsonObject.put("vhost","/" );

        Request
            .Post(url)
            .bodyString(jsonObject.toString(), ContentType.APPLICATION_JSON)
            .addHeader("authorization","Basic cmFiYml0bXE6cmFiYml0bXE=")
            .execute()
            .returnResponse()
            .getStatusLine()
            .getStatusCode();
    }

    public void postForm() throws IOException {
        String url = "";

        List<NameValuePair> nameValuePairs = Form.form()
            .add("key1", "value1")
            .add("key2", "value2")
            .build();

        Request
            .Post(url)
            .bodyForm(nameValuePairs)
            .addHeader("authorization","Basic cmFiYml0bXE6cmFiYml0bXE=")
            .execute()
            .returnResponse()
            .getStatusLine()
            .getStatusCode();
    }

}
