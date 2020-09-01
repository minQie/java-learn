package priv.wmc.study.basic.execute.order;

import lombok.extern.slf4j.Slf4j;

/**
 * 父类
 * 
 * @author 王敏聪
 * @date 2020-03-14 14:50
 */
@Slf4j
public class Parent {

    public static final String TAG = "父类";

    /** 父类静态变量初始化 */
    public static int staticVariable1 = print("代码位置1：" + TAG + "静态变量初始化1");

    /** 静态代码块 */
    static {log.info("代码位置2：" + TAG + "静态代码块1");}

    /** 父类静态变量初始化 */
    public static int staticVariable2 = print("代码位置3：" + TAG + "静态变量初始化2");

    /** 静态代码块 */
    static {log.info("代码位置4：" + TAG + "静态代码块2");}

    /** 成员变量初始化 */
    public int variable1 = print("代码位置5：" + TAG + "成员变量初始化1");

    /** 代码块 */
    {log.info("代码位置6：" + TAG + "代码块1");}

    /** 成员变量初始化 */
    public int variable2 = print("代码位置7：" + TAG + "成员变量初始化2");

    /** 代码块 */
    {log.info("代码位置8：" + TAG + "代码块2");}

    /** 构造函数 */
    Parent() {
        log.info("代码位置9：" + TAG + "构造函数");
    }

    public static int print(String msg) {
        log.info(msg);
    	return 0;
	}
}
