package priv.wmc.study.other.regex;

import org.junit.Test;

/**
 * @author 王敏聪
 * @date 2019-10-15 15:28
 */
public class MesFormParamVerifyTest {

    @Test
    public void test() {

        String a = "^[\u4e00-\u9fa5a-zA-Z0-9\\s\\-,*._·&()（）]+$";
        RegexUtil.isMatch(a, "");


        /*
         * 名称：由中文、英文字母、数字、*·_ /-.,中文括号,英文括号,&,空格组成（不能为空）
         * \u4e00-\u9fa5    中文
         * a-zA-Z            大小写英文字母
         * 0-9                数字
         * \\s                任何空白字符，包括空格、制表符、换页符等。与 [ \f\n\r\t\v] 等效
         * \\-        		特殊字符“-”
         * ,*._·&()（）		其他特殊字符
         */
        String nameRegex = "^[\u4e00-\u9fa5a-zA-Z0-9\\s\\-,*._·&()（）]+$";
        RegexUtil.isMatch(nameRegex, "-,*._·&()（）");


        /*
         * 编号：由英文字母、数字、*·_ /-.,中文括号,英文括号,&,空格组成（不能为空）
         */
        String codeRegex = "^[a-zA-Z0-9\\s\\-,*._·&()（）]+$";
        RegexUtil.isMatch(codeRegex, "小明");

        /*
         * 电话
         */
        String phoneRegex = "^(0\\d{2,3}-\\d{7,8})|(1[3456789]\\d{9})$";
        RegexUtil.isMatch(phoneRegex, "18942350318");

        /*
         * 详见：https://www.cnblogs.com/lst619247/p/9289719.html
         * 邮箱（只允许英文字母、数字、下划线、英文句号、以及中划线组成）
         * 一般规律：[N级域名][三级域名.]二级域名.顶级域名
         */
        String emailRegex = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        RegexUtil.isMatch(emailRegex, "123@163.com");

    }

}
