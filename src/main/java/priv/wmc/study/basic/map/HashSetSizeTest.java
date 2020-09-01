package priv.wmc.study.basic.map;

import java.util.HashSet;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 关于HashSet、HashMap默认初始大小，详见：hashSet.HashSet(Collection<? extends E> c)
 *
 * @author 王敏聪
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
    }
    
}
