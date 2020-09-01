package priv.wmc.study.basic.clone;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 测试 JDK API中：Object 类本身不实现接口 Cloneable，所以在类为 Object 的对象上调用 clone 方法将会导致在运行时抛出异常
 *
 * 要被克隆的类要求
 * 1、重载Object的protected Object clone()方法
 * 2、实现Cloneable接口
 */
@Slf4j
public class Demo {

    @Test
    public void demo() throws CloneNotSupportedException {
        Person p = new Person("小明");
        Person clone = p.clone();
        log.info(String.valueOf(p == clone));
    }

    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    class Person implements Cloneable {

        private String name;

        @Override
        public Person clone() throws CloneNotSupportedException {
            return (Person) super.clone();
        }
    }
}
