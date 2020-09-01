package priv.wmc.study.basic.string;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Wang Mincong
 * @date 2020-07-21 20:19:45
 */
@Slf4j
public class TemplateFormatTest {

    private static final String TEMPLATE1 = "%s%d";
    private static final String TEMPLATE2 = "%s%4d";
    private static final String TEMPLATE3 = "%s%04d";

    @Test
    public void test() {
        /// java.util.IllegalFormatConversionException: d != java.lang.String
//        log.info(String.format(TEMPLATE1, "ABC", "001"));

//        log.info(String.format(TEMPLATE2, "ABC", 1));
//        log.info(String.format(TEMPLATE3, "ABC", 1));

        log.info(String.format("%32s", "bilibili").replace(' ', '0'));

    }

}
