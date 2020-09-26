package priv.wmc.study.other.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Wang Mincong
 * @date 2019-11-06 17:40
 */
@Slf4j
public final class RegexUtil {

    private RegexUtil() {}

    private static final String CATCH_PRINT_TEMPLATE = "【捕获组下标：%s】%s ";

    /**
     * 给定的字符串是否 匹配 给定的正则表单式（默认打印结果）
     *
     * @param regex
     * @param string
     * @return
     */
    public static boolean isMatch(String regex, String string) {
        return isMatch(regex, string, true);
    }

    /**
     * 给定的字符串是否 匹配 给定的正则表单式
     *
     * @param regex
     * @param string
     * @param needPrintResult
     * @return
     */
    public static boolean isMatch(String regex, String string, boolean needPrintResult) {
        Pattern pattern = Pattern.compile(regex);
        boolean match = pattern.matcher(string).matches();
        if (needPrintResult) {
            log.info("是否匹配: " + (match? "是": "否"));
        }
        return match;
    }

    public static boolean catchPrint(String regex, String string) {
        return catchPrint(regex, string, true);
    }

    /**
     * 打印输出给定的正则表达式作为捕获组去捕获指定文本得到的内容<br>
     * （这里提及一个概念，就是你一个完整正则表达式默认就是一个捕获组 {@link #catchPrintTest}是遇到坑的记录）<br>
     * <br>
     * Api说明：
     * Matcher.groupCount() - 正则表达式中捕获组的数量（详见源码文档注释 - 不包括下标为0的、即默认的整个正则表达式的捕获组）<br>
     * Matcher.matcher() - 给定文本是否匹配这个完整的正则表达式（结合实例的现象，不是很理解）<br>
     *<br>
     * @param regex 作为捕获组的正则表达式
     * @param string 要被捕获的问本内容
     * @param singleMatch 调用者能够针对自己编写的regex类型做打印输出的效果是否为一次捕获
     * @return 是否有捕获到内容
     */
    public static boolean catchPrint(String regex, String string, boolean singleMatch) {
        Matcher matcher = Pattern.compile(regex).matcher(string);

        // 正则表达式中定义的捕获组数量
        int regexCaptureGroupSum = matcher.groupCount();

        // 正则表达式作为捕获组，捕获的次数
        int catchRound = 0;

        while (matcher.find()) {
            ++catchRound;
            if (singleMatch) {
                // 在单次匹配模式下对是否真的只有单词匹配进行校验
                if (catchRound != 1) {
                    String errorMsg = "您输入的文本：【%s】能够与指定的正则表达式：【%s】进行多处匹配";
                    throw new IllegalArgumentException(String.format(errorMsg, string, regex));
                }
            } else {
                // 能够进行多次匹配的话，打印每一轮的头
                log.info("--- 第" + catchRound + "次捕获 ---");
            }

            for (int index = 0; index <= regexCaptureGroupSum; index++) {
                // 捕获到的内容答应
                if (index < regexCaptureGroupSum) {
                    System.out.print(String.format(CATCH_PRINT_TEMPLATE, index, matcher.group(index)));
                } else {
                    log.info(String.format(CATCH_PRINT_TEMPLATE, index, matcher.group(index)));
                }
            }
        }

        if (catchRound == 0) {
            log.info("无捕获内容");
            return false;
        }

        return true;
    }

    /**
     * 想要获取捕获组的内容，就一定要先捕获（"matches"和"find"都行，但是注意，"find"调用是接着向下捕获的意思）
     */
    @Deprecated
    public static void catchPrintTest(String regex, String string) {
        Matcher matcher = Pattern.compile(regex).matcher(string);
        /*
           实例
               ab 匹配 a(?=b) 的结果本应该返回true，且匹配的应该是 a（Regex在线测试的）

           测试：
               1、matches 方法返回值是什么是否全部匹配，不是很懂，反正上面的例子中返回的是false
               2、group 方法要基于 find 方法的返回值是 true 的基础上才匹配的到、查找的到

           资料
               https://stackoverflow.com/questions/8923398/regex-doesnt-work-in-string-matches

           巴拉巴拉的废话就不说了，根据现象 臆想 的规律如下：
               matches、groupCount、find 任意一个方法执行完，相当于会移动查找的记录指针，重而使 find 方法的返回值是 false
               group 是基于这个指针值去取值的
         */

        // 给定的字符串是否匹配正则表达式
        boolean isMatches = matcher.matches();
        log.info("是否匹配：" + isMatches);

        // 打印捕获组的内容
        int groupCount = matcher.groupCount();
        log.info("捕获数量：" + groupCount);
        // ps：0下标代表整个正则表达式匹配的内容，即默认正则表达式匹配内容（可以这样理解任何表达式默认都是一个捕获组）
        for (int i = 0; i <= groupCount; i++) {
            try {
                if (matcher.find()) {
                    log.info(i + ": " + matcher.group(i));
                } else {
                    log.info(i + ": " + "没有捕获到内容");
                }
            } catch (IllegalStateException e) {
                log.info("IllegalStateException: " + e.getMessage());
            }
        }
    }

}
