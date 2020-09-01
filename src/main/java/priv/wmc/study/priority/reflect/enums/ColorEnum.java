package priv.wmc.study.priority.reflect.enums;

/**
 * @author Wang Mincong
 * @date 2020-08-08 18:22:00
 */
public enum ColorEnum {

    /** 白色 */
    @Hello("白色")
    WHITE,
    /** 黑色 */
    @Hello("黑色")
    BLACK;

    // 枚举编译后的内容大致如下：
//    public class ColorEnumCompile extends Enum<ColorEnumCompile> {
//
//    public static final ColorEnumCompile WHITE = new ColorEnumCompile("WHITE", 0);
//    public static final ColorEnumCompile BLACK = new ColorEnumCompile("BLACK", 1);
//
//    private ColorEnumCompile(String name, int ordinary) {
//        super(name, ordinary);
//    }
//
//    ...
//
//}

}
