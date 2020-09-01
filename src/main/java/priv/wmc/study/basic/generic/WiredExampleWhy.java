package priv.wmc.study.basic.generic;

import org.junit.Test;

/** 
 * 测试泛型在继承关系下的表现
 * 
 * @author 王敏聪
 * @date 2020-04-27 15:31
 */
public class WiredExampleWhy {

    @Test
    public void demo() {
        // 分析：Parent 类的泛型T决定了，方法 getT 的返回值
        // 而通过 Child 类去体现 Parent 的类型，按直觉理解，因为 Child 类定义时，将 Parent父类的泛型固定为B了
        // 所以照理说，只要是通过A的引用，调用 Parent 的 getT 方法，返回值类型都应该是B，而反例是下面的这个例子
        Object obj = new Child().getT();
    }

    /** 静态内部类1 */
    static class A {}

    /** 静态内部类2 */
    static class B extends A {}

    /** 静态内部类3 */
    static class Parent<T> {
        public T getT() {
            return null;
        }
    }

    /** 静态内部类4 */
    static class Child<T> extends Parent<B> {}

}
