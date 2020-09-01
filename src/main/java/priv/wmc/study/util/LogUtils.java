package priv.wmc.study.util;

import java.util.Collection;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Wang Mincong
 * @date 2020-07-30 22:04:00
 */
@Slf4j
public final class LogUtils {

    private LogUtils() {}

    public static void log(Object obj) {
        log.info(String.valueOf(obj));
    }

    public static void log(int i) {
        log.info(String.valueOf(i));
    }

    public static void log(Integer i) {
        log.info(String.valueOf(i));
    }

    public static <K, V> void log(Map<K, V> map) {
        log.info(map.toString());
    }

    public static <T> void log(Collection<T> collection) {
        log.info(collection.toString());
    }

}
