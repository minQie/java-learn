package priv.wmc.study.basic.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import priv.wmc.study.util.LogUtils;

/**
 * @author Wang Mincong
 */
@Slf4j
public class HashMapBasicTest {

    @Test
    public void demo() {
        this.duplicateKeyTest();
    }

    /**
     * 添加键重复的元素
     */
    public void duplicateKeyTest() {
        Map<String, String> map = new HashMap<>(16);

        map.put("hobby", "1");
        map.put("hobby", "2");
        LogUtils.log(map);
    }

    /**
     * Raw use of parameterized class 'Map'
     */
    public void genericExample() {

        // 定义一个不声明泛型的Map（不论时实际时什么类型，编译时期看声明类型）
        Map map = new HashMap<String, String>(16);
        map.put(1, "a");
        map.put(2, "b");

        // 通过entrySet方法获取的Set也就是没有泛型的
        Set set = map.entrySet();

        // foreach语法遍历时，只能用Object接收进行遍历
        for(Object obj : map.entrySet()) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>)obj;
            String key = entry.getKey();
            String value = entry.getValue();
            log.info(key + " : " + value);
        }
    }

    /**
     * 数组也是对象，可以作为泛型的类型
     */
    public void arrayTypeExample() {
        Map<int[], String> map = new HashMap<>(16);
    }
}
