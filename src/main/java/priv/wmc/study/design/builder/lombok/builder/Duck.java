package priv.wmc.study.design.builder.lombok.builder;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Wang Mincong
 * @date 2020-09-19 23:55:38
 */
@Builder
@Getter
@Setter
public class Duck extends Animal {

    private String species;

    @Override
    public String toString() {
        return String.format("[name:%s, age:%s , species:%s]", getName(), getAge(), species);
    }

}
