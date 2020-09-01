package priv.wmc.study.jdk8.nashorn_javascript;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import lombok.extern.slf4j.Slf4j;

/**
 * jjs是个基于Nashorn引擎的命令行工具。它接受一些JavaScript源代码为参数，并且执行这些源代码
 *
 * Nashorn 一个 javascript 引擎
 * 从JDK 1.8开始，Nashorn取代Rhino(JDK 1.6, JDK1.7)成为Java的嵌入式JavaScript引擎
 * Nashorn完全支持ECMAScript 5.1规范以及一些扩展
 * 它使用基于JSR 292的新语言特性，其中包含在JDK 7中引入的 invokedynamic，将JavaScript编译成Java字节码
 * 与先前的Rhino实现相比，这带来了2到10倍的性能提升
 *
 * @author 王敏聪
 * @date 2019-08-24 17:05
 */
@Slf4j
public class JavaScript {

    public static void main(String[] args) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");

        Integer result = null;
        try {
            nashorn.eval("print('hello nashorn!')");
            result = (Integer) nashorn.eval("10 + 2");

        } catch(ScriptException e) {
            log.info("执行脚本错误: "+ e.getMessage());
        }

        log.info(result.toString());
    }

}
