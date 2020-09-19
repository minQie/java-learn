package priv.wmc.study.basic.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Wang Mincong
 * @date 2020-07-21 20:58:43
 */
@Slf4j
public class DateTransTest {

    public static void main(String[] args) throws ParseException {

        String format = "yyyy-MM-dd hh:mm:ss a";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.ENGLISH);

        String dateString = "2018-01-01 00:00:00 AM";
//        String dateString2 = "2018-01-01 00:00:00 PM";

        // String -> Date
        Date date = sdf.parse(dateString);
        // Date -> String
        String parseDateString = sdf.format(date);
        log.info(parseDateString);
    }
}
