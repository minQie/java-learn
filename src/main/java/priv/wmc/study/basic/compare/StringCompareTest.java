package priv.wmc.study.basic.compare;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 字符串缓存池：jvm会将所有字符串常量缓存到缓冲池中，获取字符串常量时，会优先从缓存池中获取
 * string.intern()：从字符串池里检查是否存在，如果存在，就返回池里的字符串；如果不存在，将其添加到字符串池中，然后再返回它的引用
 *
 * 1.基本数据类型，也称原始数据类型。byte,short,char,int,long,float,double,boolean，只能进行双等号（==）的值比较
 * 2.复合数据类型
 * JAVA当中所有的类都是继承于Object这个基类的，在Object中的基类中定义了一个equals的方法，这个方法的初始行为是比较对象的内存地址，
 * 但在一些类库当中这一行为被更合理的覆盖掉了，如String,Integer,Date在这些类当中equals有其自身的实现，而不再是比较类在堆内存中的存放地址了
 *
 * 因为Object的equals方法也是用双等号（==）进行比较的，所以比较后的结果跟双等号（==）的结果相同
 *
 * @author Wang Mincong
 * @date 2020-07-21 18:47:43
 */
@Slf4j
public class StringCompareTest {

    @Test
    public void test() {
        stringCompareDemo();
    }

    public void stringCompareDemo() {
        String name1 = "小明";
        String name2 = "小明";
        String name3 = new String("小明");
        String name4 = name3.intern();

        log.info(String.valueOf(name1 == name2));
        log.info(String.valueOf(name1.equals(name2)));

        log.info(String.valueOf(name1 == name3));
        log.info(String.valueOf(name1.equals(name3)));

        log.info(String.valueOf(name1 == name4));
        log.info(String.valueOf(name1.equals(name4)));
    }

}
