package priv.wmc.study.jdk8.date;

import java.time.Instant;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/** 
 * 时间戳
 * 
 * @author 王敏聪
 * @date 2020-03-03 16:47
 */
@Slf4j
public class InstantTest {
    
    @Test
    public void demo() {
        Instant instant = Instant.now();
        // Obtains an instance of {@code Instant} from a text string such as {@code 2007-12-03T10:15:30.00Z}.
//        instant.parse("");
        
        log.info(instant.toString());
    }

}
