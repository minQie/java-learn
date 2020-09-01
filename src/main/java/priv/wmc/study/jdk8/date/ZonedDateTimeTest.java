package priv.wmc.study.jdk8.date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 日期和时间，包含时区
 *
 * @author 王敏聪
 * @date 2020-03-03 16:52
 */
@Slf4j
public class ZonedDateTimeTest {

    @Test
    public void demo() {
//        ZonedDateTime zoneDateTime = ZonedDateTime.now();

        // ZoneId.SHORT_IDS.get("CTT") -> Asia/Shanghai
        ZoneId zone = ZoneId.of("Asia/Shanghai");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), zone);

        log.info(zonedDateTime.toString());
    }

}
