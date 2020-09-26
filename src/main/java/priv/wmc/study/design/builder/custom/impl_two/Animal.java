package priv.wmc.study.design.builder.custom.impl_two;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Wang Mincong
 * @date 2020-09-19 23:55:31
 */
@Getter
@Setter
@ToString
abstract class Animal {

    private String name;

    private Integer age;

    /**
     * 抽象类定义构造方法？在哪里调用？
     * 答：可以在子类的构造函数中通过 super 关键字调用
     */
    protected Animal(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    protected abstract static class AnimalBuilder<T extends AnimalBuilder<T>> {

        protected String name;

        protected Integer age;

        public T name(String name) {
            this.name = name;
            return (T)this;
        }

        public T age(Integer age) {
            this.age = age;
            return (T)this;
        }

        /**
         * 构建方法
         *
         * @return Animal实例
         */
        public abstract Animal build();
    }

}
