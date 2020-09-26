package priv.wmc.study.jdk8.date;

import java.time.Clock;
import java.util.TimeZone;

import org.junit.Test;

/** 
 * @author Wang Mincong
 * @date 2020-03-03 09:12
 */
public class Demo {
    
    @Test
    public void demo() {
        long currentTimeMillis = System.currentTimeMillis();
        TimeZone timeZone = TimeZone.getDefault();
        Clock clock = Clock.systemUTC();
        Clock defaultZone = Clock.systemDefaultZone();
    }

}
