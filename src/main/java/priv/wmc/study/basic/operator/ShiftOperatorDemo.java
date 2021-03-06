package priv.wmc.study.basic.operator;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 位移操作符，参见：https://zhuanlan.zhihu.com/p/97749860
 *
 * 计算机中存储数据，都是用补码存储的
 *
 * 算数位移：考虑符号位
 * 逻辑位移：就是不考虑符号位，移位的结果只是数据所有的位数进行移位。根据移位操作的目的，左移时，低位补0，右移时，高位补0
 *
 * @author Wang Mincong
 * @date 2020-08-28 22:25:49
 */

@Slf4j
public class ShiftOperatorDemo {

    @Test
    public void test() {
        //  1：00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000001（补码 - 计算机中存储）
        // -1：10000000 00000000 00000000 00000000 00000000 00000000 00000000 00000001（原码）
        // -1：11111111 11111111 11111111 11111111 11111111 11111111 11111111 11111111（补码 - 计算机中存储）


        // 一、>> 右移运算符 相当于除以二
        // 右移一位 & 最高位补1 故值没变
        int i1 = -1 >> 1;


        // 二、<< 左移运算符 相当于乘二
        // 左移一位 & 末位补0 故值为2
        // 为什么 11111111 11111111 11111111 11111111 11111111 11111111 11111111 11111110 表示-2
        // 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000010 取反 + 1
        int i2 = -1 << 1;

        // 三、>>> 无符号右移，忽略符号位，空位都以0补齐
        // 右移一位 & 最高位补1 故值为2147483647
        // 01111111 11111111 11111111 11111111 11111111 11111111 11111111 11111111
        int i3 = -1 >>> 1;


        // 四、<<< 不存在

        log.info(String.valueOf(i1));
        log.info(String.valueOf(i2));
        log.info(String.valueOf(i3));

        // 8位 最大能表示的正数
        // 0111 1111 - 127

        // 1111 1111（原码 - 127） → 1000 0000（反码） → 1000 0001（补码）

        // 8位 最大能表示的负数
        // 1000 0000 - -128（特殊，无原码、反码）
        // 为什么-128没有原码和反码？
        // 首先看-0，[-0]原码=1000 000，其中1是符号位，求反操作，算出[-0]反码=1111 1111，
        // 再看-128，假如它有原码且[-128]原码=1000 000，假如让-128也有反码，求反操作，则[-128]反码=1111 1111，
        // 你会发现，-128的反码和-0的反码相同，所以为了避免面混淆，有了-0的原码，便不能有-128的原码补码，这是8位比特位位数限制决定的
    }

}
