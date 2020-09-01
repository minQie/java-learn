package priv.wmc.study.constant;

/**
 * 文件相关常量
 *
 * @author Wang Mincong
 * @date 2020-08-03 21:10:13
 */
public final class FileConstant {

    private FileConstant() {}

    /**
     * Guava：有定义 StandardSystemProperty.LINE_SEPARATOR 了解一下
     * Logback：有定义 CoreConstants.LINE_SEPARATOR
     */
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

}
