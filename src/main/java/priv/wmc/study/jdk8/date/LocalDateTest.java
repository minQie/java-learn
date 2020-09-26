package priv.wmc.study.jdk8.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/** 
 * 日期，不存储时间
 * 
 * @author Wang Mincong
 * @date 2020-03-03 16:48
 */
@Slf4j
public class LocalDateTest {
    
    @Test
    public void demo() {
        LocalDate localDate = LocalDate.now();
        localDate = LocalDate.of(2020, 3, 3);
        
        // 周月年的第几天
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        log.info("dayOfWeek: " + dayOfWeek);
        int dayOfMonth = localDate.getDayOfMonth();
        log.info("dayOfMonth: " + dayOfMonth);
        int dayOfYear = localDate.getDayOfYear();
        log.info("dayOfYear: " + dayOfYear);
        
        // 当月是今年的几月
        int monthValue = localDate.getMonthValue();
        log.info("monthValue: " + monthValue);
        
        // 2020
        int year = localDate.getYear();
		log.info("year: " + year);
		
		// 是否是闰年
		LocalDate.now().isLeapYear();
		
		// 跃后的时间
//		localDate.plusDays(1);
//		localDate.plusWeeks(1);
//		localDate.plusMonths(1);
//		localDate.plusYears(1);
		log.info(localDate.toString());
		
		// String -> LocalDate
		LocalDate parse = LocalDate.parse("20200303", DateTimeFormatter.BASIC_ISO_DATE);
		log.info(parse.toString());
	}

}
