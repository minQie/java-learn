package priv.wmc.study.jdk7;

import org.junit.Test;

/**
 * <p>1、JDK7开始，终于可以用二进制来表示整数（byte,short,int和long）
 * <p>使用二进制字面量的好处是，可以使代码更容易被理解
 *
 * <p>2、为了增强对数值的阅读性，如我们经常把数据用逗号分隔一样。JDK7提供了_对数据分隔
 *      不能出现在进制标识和数值之间
 *      不能出现在数值开头和结尾
 *      不能出现在小数点旁边
 *
 * @author Wang Mincong
 * @date 2020-07-25 15:12:34
 */
public class BinaryPerformanceTest {

    @Test
    public void test() {
        // 7
        byte byteVar = 0b01111111;
        // 15 这里边有点名堂
        short shortVar = 0b01111111_11111111;
        // 32
        int intVar = 0b01111111_11111111_11111111_11111111_1;
        // 64
        long longVar = 0b11111111_11111111_11111111_11111111_11111111_11111111_11111111_11111111L;

        System.out.println("byte" + byteVar);
        System.out.println("short" + shortVar);
        System.out.println("int" + intVar);
        System.out.println("long" + longVar);

        // 下划线使用注意

        // 不能和小数点相邻
//        float floatVar = 3_.14F;
//        float floatVar = 3._14F;

        // 不能放在开头或者结尾
//        int intVar = _1;
//        int intVar = 1_;

        // 只要符合添加位置，不限制添加的数量
//        int intVar = 1______2;



    }

}
