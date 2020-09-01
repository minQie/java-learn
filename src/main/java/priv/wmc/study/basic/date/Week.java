package priv.wmc.study.basic.date;

import java.util.Calendar;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;

/** 
 * @author 王敏聪
 * @date 2019-08-24 16:11
 */
@Slf4j
public class Week {

    /**
     * 返回参数Date对应的星期几
     * @param date
     * @return
     */
    public static String method(Date date) {
        String[] weekOfDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar calendar = Calendar.getInstance();
        if(date != null){
            calendar.setTime(date);
        }
        log.info(String.valueOf(calendar.get(Calendar.DAY_OF_WEEK)));
        int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0){
            w = 0;
        }
        log.info(String.valueOf(w));
        return weekOfDays[w];
    }
}
