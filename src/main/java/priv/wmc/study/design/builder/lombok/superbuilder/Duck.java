package priv.wmc.study.design.builder.lombok.superbuilder;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @author Wang Mincong
 * @date 2020-09-19 23:55:38
 */
@Getter
@SuperBuilder
public class Duck extends Animal {

    private String species;

    @Override
    public String toString() {
        return String.format("[name:%s, age:%s , species:%s]", getName(), getAge(), species);
    }

}
