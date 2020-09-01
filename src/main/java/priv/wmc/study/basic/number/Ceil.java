package priv.wmc.study.basic.number;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Wang Mincong
 * @date 2020-07-21 20:38:04
 */
@Slf4j
public class Ceil {
    public static void main(String[] args) {
        // 向上取整ceil，参数需要严格为double数据类型的才能有效实现向上取整的效果
        int sum = (int) Math.ceil(8/3);
        log.info(String.valueOf(sum)); // 2

        sum = (int) Math.ceil(8.0/3);
        log.info(String.valueOf(sum)); // 3
    }
}