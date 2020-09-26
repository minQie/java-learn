package priv.wmc.study.design.builder.custom.impl_one;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Wang Mincong
 * @date 2020-09-19 23:55:38
 */
@Getter
@Setter
public class Duck extends Animal {

    private String species;

    private Duck(String name, Integer age, String species) {
        super(name, age);
        this.species = species;
    }

    public static DuckBuild builder() {
        return new DuckBuild();
    }

    @Override
    public String toString() {
        return String.format("Duck(name=%s, age=%s, species=%s)", getName(), getAge(), getSpecies());
    }

    public static class DuckBuild extends AnimalBuilder<DuckBuild> {

        private String species;

        public DuckBuild species(String species) {
            this.species = species;
            return this;
        }

        @Override
        public Duck build() {
            return new Duck(name, age, species);
        }
    }

}
