package priv.wmc.study.basic.generic.builder_test;

import org.junit.Test;

/**
 * 这里的Demo是从构建者设计模式的set方法以及实现构建者模式的子类引出的泛型问题
 *
 * @author Wang Mincong
 * @date 2020-06-30 17:01:57
 */
public class JuniorPerformanceTest {

    @Test
    public void test() {
        /// 凉凉：因为a方法的返回值类型是Parent
//        new Child().a().b();

        // 没问题
        new Child().b().a();
    }

    static class Parent {

        public Parent a() {
            return this;
        }

    }

    static class Child extends Parent {

        public Child b() {
            return this;
        }

    }

}
