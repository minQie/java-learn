package priv.wmc.study.jdk8.date;

import java.time.LocalDateTime;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 时间和日期，但不包含时区
 *
 * @author Wang Mincong
 * @date 2020-03-03 16:51
 */
@Slf4j
public class LocalDateTimeTest {

    @Test
    public void demo() {
        LocalDateTime localDateTime = LocalDateTime.now();

        log.info(localDateTime.toString());
    }

}
