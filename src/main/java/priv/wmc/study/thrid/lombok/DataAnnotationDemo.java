package priv.wmc.study.thrid.lombok;

import lombok.Data;

/** 
 * 测试@Data
 * 
 * 1、@Data 等效于 @ToString @EqualsAndHashCode, @Getter on all fields, @Setter on all non-final fields, and @RequiredArgsConstructor
 * 2、替代三种注解的staticName属性，@Data使用staticConstructor来实现同样的效果
 * 
 * @author Wang Mincong
 * @date 2019-08-19 15:00
 */
@Data(staticConstructor = "of")
public class DataAnnotationDemo<T> {

    private final T t;

}
