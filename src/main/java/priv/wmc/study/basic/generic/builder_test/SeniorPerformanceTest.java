package priv.wmc.study.basic.generic.builder_test;

import org.junit.Test;

/**
 * @author Wang Mincong
 * @date 2020-06-30 17:01:57
 */
public class SeniorPerformanceTest {

    @Test
    public void test() {
        // 没问题
        new Child().a().b();
        new Child().b().a();
    }

    static class Parent<T extends Parent<T>> {
        public T a() {
            return (T)this;
        }
    }

    static class Child extends Parent<Child> {
        public Child b() {
            return this;
        }
    }

}
