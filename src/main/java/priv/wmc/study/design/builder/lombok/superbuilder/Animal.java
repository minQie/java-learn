package priv.wmc.study.design.builder.lombok.superbuilder;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author Wang Mincong
 * @date 2020-09-19 23:55:31
 */
@Getter
@SuperBuilder
public class Animal {

    private String name;

    private Integer age;

}
