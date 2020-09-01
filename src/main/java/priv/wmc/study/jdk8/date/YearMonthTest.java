package priv.wmc.study.jdk8.date;

import java.time.Month;
import java.time.YearMonth;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/** 
 * @author 王敏聪
 * @date 2020-03-03 16:53
 */
@Slf4j
public class YearMonthTest {
    
    @Test
    public void demo() {
        YearMonth now = YearMonth.now();
        log.info(String.format("当前月份[%s]，有[%s]天", now.getMonth().getValue(), now.getMonthValue()));
        
        YearMonth yearMonth = YearMonth.of(2020, Month.MARCH);
        log.info(yearMonth.toString());
    }

}
