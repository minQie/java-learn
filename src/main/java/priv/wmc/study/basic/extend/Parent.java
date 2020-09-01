package priv.wmc.study.basic.extend;

import lombok.Getter;

/**
 * @author 王敏聪
 * @date 2019-08-27 12:39
 */
@Getter
public class Parent {

    public static String secret = "爹的秘密";

    protected final String name;

    protected Parent(String name) {
        this.name = name;
    }

}
