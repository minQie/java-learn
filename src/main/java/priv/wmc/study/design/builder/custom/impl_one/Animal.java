package priv.wmc.study.design.builder.custom.impl_one;

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
public class Animal {

    private String name;

    private Integer age;

    protected Animal(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public static <T extends AnimalBuilder<T>> AnimalBuilder<T> builder() {
        return new AnimalBuilder<>();
    }

    protected static class AnimalBuilder<T extends AnimalBuilder<T>> {

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

        public Animal build() {
            return new Animal(name, age);
        }
    }

}
