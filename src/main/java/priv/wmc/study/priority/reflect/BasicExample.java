package priv.wmc.study.priority.reflect;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author 王敏聪
 * @date 2019-12-10 09:49
 */
@Slf4j
public class BasicExample {

    @Test
    public void demo() {
        /// B类是否A类的子类，或者B类是否实现了A接口
        // A.class.isAssignableFrom(B.class);

        // 判断是不是数组类型
        // Clazz<?>.isArray()

        // 获取数组存储的真实类型（如果不是数组返回null）
        // Clazz<?>.getComponentType()
    }

}
