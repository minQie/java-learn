package priv.wmc.study.other.regex;

import org.junit.Test;

/**
 * 捕获组和非捕获组（了解基本的概念，简单的应用）<br>
 * 一、捕获组 (xxx)<br>
 * 1、否定概念 - 不包含的业务<br>
 * 2、反向引用（捕获组引用）- 叠词的业务<br>
 * 3、前瞻、后顾 - 高级底层概念<br>
 *<br>
 * 二、非捕获组 (?:xxx)<br>
 * 1、非捕获组不是只用于取反，取反理所当然是非捕获组，不能本末倒置<br>
 * 2、非捕获组与熟知的捕获组的差别仅在于，不会被捕获结果<br>
 *<br>
 * @author Wang Mincong
 * @date 2019-11-07 16:14
 */
public class CatchTest {

    /**
     * 正向否定预查(negative assert) - (?!pattern)
     */
    @Test
    public void matchTest() {
        // 不以 123 开头的
        RegexUtil.isMatch("^(?!123).*$", "123");
        // 不以 123 开头的（加上非贪婪匹配符优化）
        RegexUtil.isMatch("^(?!123).*?$", "123");

        // 不包含 123 的（错误示例 - 因为前瞻开头的 .*? 匹配空，后面的 .*? 匹配所有的 123，所以返回结果式匹配的）
        RegexUtil.isMatch("^.*?(?!123).*?$", "123");
        // 不包含 123 的
        RegexUtil.isMatch("^(?!.*?123).*?$", "123");
        // 不包含 123 的（实现方式不同优化）
        RegexUtil.isMatch("^((?!123).)*?$", "123");
    }

    /**
     * 上面是直接匹配测试，当前是添加捕获组来更好的了解正则表达式起到了什么样的作用
     */
    @Test
    public void catchTest() {
        RegexUtil.catchPrint("^(?!123)(.*)$", "123");
        RegexUtil.catchPrint("^(?!123)(.*?)$", "123");

        RegexUtil.catchPrint("^(.*?)(?!123)(.*?)$", "123");
        RegexUtil.catchPrint("^(?!(.*?)123)(.*?)$", "123");
        RegexUtil.catchPrint("^((?!123).)*?$", "123");
    }


    /**
     * 叠词（捕获组的反向引用）
     *
     * 捕获组命名 语法：(?<捕获组名>捕获内容) 或者 (?'捕获组名'捕获内容)
     * 反向引用 语法：\\下标 或者 \\k<捕获组名>
     */
    @Test
    public void reduplicationTest() {
        // 下标引用
        RegexUtil.isMatch("(\\d{2})\\1", "1212");
        // 名称引用
        RegexUtil.isMatch("(?<reduplication>\\d{2})\\k<reduplication>", "1212");
    }

    /**
     * 正则表达式中 前瞻、后顾 的概念
     */
    @Test
    public void seniorTest() {
        // 前瞻：hard 前面得是 work
        RegexUtil.catchPrint("work(?=hard)", "workhard");
        // 后顾：work 后面得是 hard
        RegexUtil.catchPrint("(?<=work)hard", "workhard");
        // 负前瞻：work 后面不能是 hard
        RegexUtil.catchPrint("work(?!hard)", "workhard");
        // 负后顾：hard 前面不能是 work
        RegexUtil.catchPrint("(?<!work)hard", "workhard");
    }

}
