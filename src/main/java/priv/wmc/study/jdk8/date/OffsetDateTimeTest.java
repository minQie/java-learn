package priv.wmc.study.jdk8.date;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/** 
 * 通过为LocalDateTime 指定偏移量ZoneOffset 产生OffsetDateTime
 * 
 * @author Wang Mincong
 * @date 2020-03-03 17:49
 */
@Slf4j
public class OffsetDateTimeTest {

    @Test
    public void demo() {
        LocalDateTime birth = LocalDateTime.of(1997, Month.OCTOBER, 5, 12, 0);
        ZoneOffset zoneOffset = ZoneOffset.of("+01:00");
        
        OffsetDateTime offsetDateTime = OffsetDateTime.of(birth, zoneOffset);

        log.info(offsetDateTime.toString());
    }
    
}
