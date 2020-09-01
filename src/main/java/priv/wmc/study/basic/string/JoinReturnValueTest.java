package priv.wmc.study.basic.string;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Wang Mincong
 * @date 2020-06-29 11:57:35
 */
@Slf4j
public class JoinReturnValueTest {

    @Test
    public void test() {
        String s = "1";
        // 123
        log.info(s += "23");
    }
}
