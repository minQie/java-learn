package priv.wmc.study.thrid.http.okhttp;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

/** 
 * @author Wang Mincong
 * @date 2020-02-05 10:43
 */
public class Demo {
    
    @Test
    public void test() {
        Map<String, String> bodyParam = new HashMap<>(2);
        bodyParam.put("name", "ok车间001");
        bodyParam.put("code", "ok001");
        OkHttpUtils.postExample(bodyParam, JSONObject.class);
    }

}
