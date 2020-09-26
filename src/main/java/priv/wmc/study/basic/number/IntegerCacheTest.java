package priv.wmc.study.basic.number;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Wang Mincong
 * @date 2020-01-04 14:14
 */
@Slf4j
public class IntegerCacheTest {

    @Test
    public void demo() {
        // 缓存范围 -128 ~ 127
        // 修改这个范围：-Djava.lang.Integer.IntegerCache.high=250（小于127，则取127、不能修改下限（-128））
        Integer a = 1;
        Integer b = 1;
        log.info(String.valueOf(a == b));

        a = 127;
        b = 127;
        log.info(String.valueOf(a == b));

        a = new Integer(1);
        b = new Integer(1);
        log.info(String.valueOf(a == b));

        a = 128;
        b = 128;
        log.info(String.valueOf(a == b));
    }

}
