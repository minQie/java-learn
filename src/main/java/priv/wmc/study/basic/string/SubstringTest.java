package priv.wmc.study.basic.string;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Wang Mincong
 * @date 2020-09-24 20:24:45
 */
@Slf4j
public class SubstringTest {

    @Test
    public void test() {
        String example1 = "abcba";
        String example2 = "abccaa";

        boolean result1 = strTest(example1);
        log.info(String.valueOf(result1));
        boolean result2 = strTest(example2);
        log.info(String.valueOf(result2));
    }

    public boolean strTest(String str) {
        if (str.length() == 1) {
           return true;
        }
        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }
        // 注意 String.subString 方法的参数1是起始下标（包括），方法的参数2是结束下标（不包括）
        return strTest(str.substring(1, str.length() - 1));
    }

}
