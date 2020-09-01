package priv.wmc.study.basic.generic.enum_test;

import lombok.Getter;

/**
 * @author Wang Mincong
 * @date 2020-06-23 13:26:08
 */
@Getter
public enum StatusEnum implements EnumDefine {

    /** 禁用 */
    DISABLE,
    /** 启用 */
    ENABLE;

    int value;

    String verbose;

}
