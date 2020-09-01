package priv.wmc.study.thrid.http.httpclient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.junit.Test;

/**
 * @author 王敏聪
 * @date 2020-02-04 20:35
 */
@Slf4j
public class Demo {

    @Test
    public void test() {
//        httpClientDemo();
    }

    public void httpClientDemo() {
        Map<String, String> parameterMap = new HashMap<>();
        parameterMap.put("buildname", "5A_2_0_5");
        parameterMap.put("roomname", "5A207");
        String resultString = null;
        try {
            resultString = HttpClientUtils.post("http://pay.nit.edu.cn/Pay/CheckRoom", parameterMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info(resultString);
    }

    /**
     * 需要httpcomponents - fluent-hc
     */
    public void httpClientDemo2() {
        // get
        try {
            Request
                .Get("http://targethost/homepage")
                .execute()
                .returnContent();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // post
        try {
            Request
                .Post("http://targethost/login")
                .bodyForm(Form.form().add("username",  "vip").add("password",  "secret").build())
                .execute()
                .returnContent();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
