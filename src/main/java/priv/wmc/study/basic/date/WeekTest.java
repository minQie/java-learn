package priv.wmc.study.basic.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.lang.Nullable;

/** 
 * @author 王敏聪
 * @date 2019-08-24 16:11
 */
@Slf4j
public class WeekTest {

    @Test
    @SneakyThrows
    public void getWeekTest() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = simpleDateFormat.parse("2020-09-07 00:00:00");

        String week = getWeek(parse);
        log.info(week);
    }

    public String getWeek() {
        return getWeek(null);
    }

    public String getWeek(@Nullable Date date) {
        String[] weekOfDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

        Calendar calendar = Calendar.getInstance();
        if(date != null){
            calendar.setTime(date);
        }

        // week calendar.get(Calendar.DAY_OF_WEEK)
        // 星期日 ~ 星期六  ←→  1 ~ 7
        return weekOfDays[calendar.get(Calendar.DAY_OF_WEEK) - 1];
    }
}
