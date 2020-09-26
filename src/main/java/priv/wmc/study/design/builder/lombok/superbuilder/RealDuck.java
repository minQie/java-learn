package priv.wmc.study.design.builder.lombok.superbuilder;

/**
 * lombok 处理完 @SuperBuilder 修饰的类编译后的代码
 *
 * @author Wang Mincong
 * @date 2020-09-20 17:17:10
 */
public class RealDuck extends RealAnimal {
    private String species;

    @Override
    public String toString() {
        return String.format("[name:%s, age:%s , species:%s]", this.getName(), this.getAge(), this.species);
    }

    protected RealDuck(DuckBuilder<?, ?> b) {
        super(b);
        this.species = b.species;
    }

    public static RealDuck.DuckBuilder<?, ?> builder() {
        return new RealDuck.DuckBuilderImpl();
    }

    public String getSpecies() {
        return this.species;
    }

    private static final class DuckBuilderImpl extends RealDuck.DuckBuilder<RealDuck, DuckBuilderImpl> {
        private DuckBuilderImpl() {
        }

        @Override
        protected DuckBuilderImpl self() {
            return this;
        }

        @Override
        public RealDuck build() {
            return new RealDuck(this);
        }
    }

    public abstract static class DuckBuilder<C extends RealDuck, B extends DuckBuilder<C, B>> extends
        AnimalBuilder<C, B> {
        private String species;

        public DuckBuilder() {
        }

        @Override
        protected abstract B self();

        @Override
        public abstract C build();

        public B species(String species) {
            this.species = species;
            return this.self();
        }

        @Override
        public String toString() {
            return "Duck.DuckBuilder(super=" + super.toString() + ", species=" + this.species + ")";
        }
    }
}
