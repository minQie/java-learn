package priv.wmc.study.jdk8.date;

import java.time.LocalTime;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 时间，不存储日期
 *
 * @author Wang Mincong
 * @date 2020-03-03 16:50
 */
@Slf4j
public class LocalTimeTest {

    @Test
    public void demo() {
        LocalTime localTime = LocalTime.now();

        log.info(localTime.toString());
    }

}
