package priv.wmc.study.jdk8.date;

import java.time.LocalDate;
import java.time.Period;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 *
 *
 * @author Wang Mincong
 * @date 2020-03-03 17:08
 */
@Slf4j
public class PeriodTest {

    @Test
    public void demo() {
        LocalDate birthday = LocalDate.of(1997, 10, 5);
        LocalDate today = LocalDate.of(2020, 3, 3);

        // 计算日期差
        Period between = Period.between(birthday, today);
        // P22Y4M27D
        log.info(String.valueOf(between.getDays()));
    }

}
