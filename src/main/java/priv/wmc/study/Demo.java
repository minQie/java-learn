package priv.wmc.study;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
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
        // 记录两个乱七八糟的点
        // 1、IntelliJ IDEA 会检测用户在idea编辑界面编辑pom.xml的操作，但是如果对pom.xml的操作来自git回滚之类的操作，maven是不会刷新依赖的，注意要手动“reimport”
        // 2、本地 Windows：在logback的配置文件、主配置文件中指定路径时，开头不写盘符，例如：/xxx/xxx 或者 \xxx\xxx，都会存放在D盘

        // false
        // if (null instanceof Object) {
        //
        // }

        // 1、方法签名 Xxx(String... s) {}和 Xxx(String[] s) {} 是冲突的
        // 2、Xxx(String... s) 可以接收 String[]、Xxx(String[]) 不能接收 String...

        // String... 和 String[] 可以相互赋值
        // String... 可以通过 Arrays.toList(String...) 得到 List<String>

        timeFormatTest();
    }

    public void timeFormatTest() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String time = sdf.format(new Date());

        log.info(time);
        String nonce = UUID.randomUUID().toString().replace("-", "");
        log.info(nonce);
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
        log.info(String.valueOf(((Object) null) instanceof Object));

        // 抛弃小数位
        int intValue = Double.valueOf("1.9").intValue();
        log.info(String.valueOf(intValue));
    }

}