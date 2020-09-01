package priv.wmc.study.basic.generic.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** 
 * Simple POJO AS Child
 * @author 王敏聪
 * @date 2019-08-09 12:42
 */
@Data
@EqualsAndHashCode(callSuper = true) 
public class Child extends Father {

    private final String username;

    public Child() {
        this.username = "未初始化";
    }

}
