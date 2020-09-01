package priv.wmc.study.basic.string;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Object to String
 *
 * @author 王敏聪
 * @date 2019-11-08 14:42
 */
@Slf4j
public class ToStringTest {

    @Test
    public void demo() {
        Object obj = null;

        String s1 = castTest(obj);
        log.info(s1);

        String s2 = addTest(obj);
        log.info(s2);

        String s3 = stringValueOfTest(obj);
        log.info(s3);

        String s4 = toStringTest(obj);
        log.info(s4);

    }

    /**
     * 显示类型转换
     */
    public String castTest(Object obj) {
        // 1、支持null
//        (String) obj(null) -> null

        // 2、Integer不能转成String
//        (String) obj(1) -> java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String

        return (String) obj;
    }

    /**
     * 通过“+”运算符使用默认的类型转换行为
     */
    public String addTest(Object obj) {
        // 1、支持null
//        "" + null -> "null"

        // 2、支持整数
//      "" + 1 -> "1"

        return "" + obj;
    }

    /**
     * String的valueOf方法
     */
    public String stringValueOfTest(Object obj) {
        // 1、支持null
//      String.valueOf(obj(null)) -> java.lang.NullPointerException

        // 2、支持整数（废话）

        return String.valueOf(obj);
    }

    /**
     * toString方法
     */
    public String toStringTest(Object obj) {
        // 1、不支持null
//      obj(null).toString() -> java.lang.NullPointerException

        // 2、支持整数（废话）

        return obj.toString();
    }

}
