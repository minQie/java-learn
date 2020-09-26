package priv.wmc.study.design.builder.custom.first_flawed;

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

    public static AnimalBuilder builder() {
        return new AnimalBuilder();
    }

    public static class AnimalBuilder {

        protected String name;

        protected Integer age;

        public AnimalBuilder name(String name) {
            this.name = name;
            return this;
        }

        public AnimalBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public Animal build() {
            return new Animal(name, age);
        }
    }

}
