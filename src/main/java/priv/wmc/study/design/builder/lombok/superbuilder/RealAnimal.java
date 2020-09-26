package priv.wmc.study.design.builder.lombok.superbuilder;

/**
 * lombok 处理完 @SuperBuilder 修饰的类编译后的代码
 *
 * @author Wang Mincong
 * @date 2020-09-20 17:16:41
 */
public class RealAnimal {

    private String name;
    private Integer age;

    protected RealAnimal(AnimalBuilder<?, ?> b) {
        this.name = b.name;
        this.age = b.age;
    }

    public static AnimalBuilder<?, ?> builder() {
        return new AnimalBuilderImpl();
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    private static final class AnimalBuilderImpl extends AnimalBuilder<RealAnimal, AnimalBuilderImpl> {
        private AnimalBuilderImpl() {
        }

        @Override
        protected AnimalBuilderImpl self() {
            return this;
        }

        @Override
        public RealAnimal build() {
            return new RealAnimal(this);
        }
    }

    public abstract static class AnimalBuilder<C extends RealAnimal, B extends AnimalBuilder<C, B>> {
        private String name;
        private Integer age;

        public AnimalBuilder() {
        }

        protected abstract B self();

        public abstract C build();

        public B name(String name) {
            this.name = name;
            return this.self();
        }

        public B age(Integer age) {
            this.age = age;
            return this.self();
        }

        @Override
        public String toString() {
            return "Animal.AnimalBuilder(name=" + this.name + ", age=" + this.age + ")";
        }
    }
}
