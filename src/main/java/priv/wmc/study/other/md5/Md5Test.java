package priv.wmc.study.other.md5;

import java.security.NoSuchAlgorithmException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Wang Mincong
 * @date 2020-07-21 19:09:11
 */
@Slf4j
public class Md5Test {

    @Test
    public void test() {
        try {
            log.info(Md5Utils.md5("123" + "1#$%^&&$%^7"));
        } catch (NoSuchAlgorithmException e) {
            log.debug("error", e);
        }
    }

}
