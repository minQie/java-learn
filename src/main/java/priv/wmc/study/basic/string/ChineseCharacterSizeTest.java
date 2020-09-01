package priv.wmc.study.basic.string;

import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Wang Mincong
 * @date 2020-07-21 21:22:07
 */
@Slf4j
public class ChineseCharacterSizeTest {

    @Test
    public void test() {
        sizeTest();
    }

    public void sizeTest() {
        final String character = "字符";

        String word = "a";
//        String word = "好";

        byte[] bytes;

        // UTF8编码格式下，一个汉字占3字节，一个字符占1字节
        bytes = word.getBytes(StandardCharsets.UTF_8);
        log.info("UTF8编码格式下，一个{}占" + bytes.length + "字节", character);

        // UTF16编码格式下，一个汉字占4字节，一个字符占4字节
        bytes = word.getBytes(StandardCharsets.UTF_16);
        log.info("UTF16编码格式下，一个{}占" + bytes.length + "字节", character);

        // 默认编码UTF-8编码格式下，一个汉字占3字节，一个字符占1字节
        bytes = word.getBytes();
        log.info("默认编码" + System.getProperty("file.encoding") + "编码格式下，一个{}占" + bytes.length + "字节", character);
    }

}
