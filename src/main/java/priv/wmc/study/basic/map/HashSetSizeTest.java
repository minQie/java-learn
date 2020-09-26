package priv.wmc.study.basic.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 关于HashSet、HashMap默认初始大小，详见：hashSet.HashSet(Collection<? extends E> c)
 *
 * @author Wang Mincong
 * @date 2020-04-29 09:59
 */
@Slf4j
public class HashSetSizeTest {

    @Test
    public void test() {
        int init = 2;

        float floatSize = (init/.75f) + 1;
        log.info("float: " + floatSize);

        int size = (int)floatSize;
        log.info("int: " + size);

        // 测试的另外一些点
        // 不指定初始大小 默认 16
        // 指定初始大小不是2的整倍数 会调整为 2的整倍数
        // 添加完第 大小 * 负载因子 + 1 个元素时，会扩容（hash桶会扩充到原来的两倍）
        Map<String, String> map = new HashMap<>(16);
        for (int i = 0; i < 16; i++) {
            map.put(String.valueOf(i) , String.valueOf(i));
        }
    }
    
}
