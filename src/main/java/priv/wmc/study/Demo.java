package priv.wmc.study;

import java.time.ZoneId;
import java.util.Random;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Wang Mincong
 * @date 2020-03-19 17:36
 */
@Slf4j
public class Demo {

    @Test
    public void test() {
        if (null instanceof Object) {

        }
    }

    public void uuidTest() {
        String uuid = UUID.randomUUID().toString();
        // 36
        log.info(String.valueOf(uuid.length()));
        // 32
        log.info(String.valueOf(uuid.replace("-", "").length()));
    }

    public void basicOperate() {
        // 日志测试：只写这一条，且日志配置的是异步将日志数据写道文件，会因为主线程结束，而导致来不及将日志数据刷到文件中，程序就结束了
        log.info("123");

        // Asia/Shanghai
        log.info(ZoneId.systemDefault().toString());

        // 获取[0, 10]范围内的整数
        int i = new Random().nextInt(10);
        log.info(String.valueOf(i));

        // 1、null instanceof 任意 - false
        // 2、基本类型 instanceof 任意 - 编译不通过
        log.info(String.valueOf(null instanceof Object));
        log.info(String.valueOf(((Object)null) instanceof Object));
    }

}