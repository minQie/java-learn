package priv.wmc.study.basic.number;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/** 
 * @author 王敏聪
 * @date 2019-09-06 23:30
 */
@Slf4j
public class AccuracyTest {
    
    @Test
    public void test() {
        // 别指望能有什么办法做到：0.1 + 0.2 = 0.3这种
        // 1、凡是在代码中显示声明的小数值都是double的高精度值
        // 2、高精度值相加好比：0.10000001 + 0.2000001 != 0.30000003（举个例子，实际有很多0了）
        // 在下面小数比较中，"小数"、"小数d"、"小数D"的效果是一样的
        log.info(String.valueOf(0.1d + 0.2d == 0.3d));// false

        float f1 = 0.1f + 0.2f;
        log.info(String.valueOf(f1 == 0.3f));// true

        float f2 = 1/10 + 2/10;
        log.info(String.valueOf(f2 == 3/10));// true

        log.info(String.valueOf(0.1 + 0.2 > 0.3));// true
    }

}
