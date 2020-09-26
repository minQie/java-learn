package priv.wmc.study.jdk8.date;

import java.time.LocalDate;
import java.time.MonthDay;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Wang Mincong
 * @date 2020-03-03 16:49
 */
@Slf4j
public class MonthDayTest {

    @Test
    public void demo() {
        LocalDate birth = LocalDate.of(1997, 10, 5);
        LocalDate now = LocalDate.now();
        log.info(String.valueOf(birth.equals(now)));

        MonthDay birthday = MonthDay.of(birth.getMonth(), birth.getDayOfMonth());
        MonthDay current = MonthDay.from(now);
        if (birthday.equals(current)) {
            log.info("今天是我生日");
        } else {
            log.info("今天不是我生日");
        }
    }

}
