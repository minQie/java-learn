package priv.wmc.study.senior.proxy.javassist.prio;

import java.io.IOException;
import java.lang.reflect.Method;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 核心：演示javassist的基本使用，并过渡到JDK动态代理<br>
 * 概念：静态代理就是我们普通的编写一个接口的实现类，然后创建实现类对象，调用接口实现方法<br>
 * 相关技术：Cglib、ASM<br>
 *<br>
 * @author Wang Mincong
 * @date 2020-07-15 23:14:13
 */
@Slf4j
public class DynamicProxyTest {

    @Test
    public void test() throws Exception {
        // javassist动态字节码生成 基础Demo
//        basicDemo();

        // javassist动态字节码生成 基础Demo升级 伪动态代理
        TemplateInterface sayHello = upgradeDemo(TemplateInterface.class, (methodName, args) -> {
            if (methodName.equals("sayHello")) {
                log.info("hello:" + args[0]);
            }
            return null;
        });
        sayHello.sayHello("WMC");
    }

    /**
     * 基础Demo针对一个接口的实现类过于解耦，没有任何拓展可言 - 想要修改实现，就要去修改动态生成实现类的代码 ->
     * 于是推出关键的实现的src，作为方法参数（没有贴出相关实现，略过此步，但是这一步的思想得体现出来） ->
     * 依旧有不足，因为String类型的src，即使有错误，在编译时期是没有任何提示的，故实现的思想如下：
     *      具体的InvocationHandler实现类作为参数传进来，动态生成的类只负责调用实现类的invoke方法
     *      （区分不同方法的逻辑，全部体现在InvocationHandler的invoke方法中）
     */
    public <T> T upgradeDemo(Class<T> targetInterfaceClass, InvocationHandler invocationHandler)
        throws CannotCompileException, IllegalAccessException, InstantiationException, NoSuchFieldException, NotFoundException {
        // 1、创建一个类、添加实现的接口声明
        ClassPool classPool = new ClassPool();
        classPool.appendSystemPath();

        CtClass ctClass = classPool.makeClass("TargetInterfaceImpl");
        ctClass.addInterface(classPool.get(targetInterfaceClass.getName()));

        // 2、添加 handler 属性
        CtField field = CtField.make("public priv.wmc.study.priority.proxy.InvocationHandler handler = null;", ctClass);
        ctClass.addField(field);

        // 3、添加接口方法实现（接口方法具体的实现就是调用 handler 的方法）、并构建 Class 对象
        String src = "return ($r)this.handler.invoke(\"%s\", $args);";
        String voidSrc = "this.handler.invoke(\"%s\", $args);";
        for (Method method : targetInterfaceClass.getMethods()) {
            CtClass returnType = classPool.get(method.getReturnType().getName());
            String methodName = method.getName();
            CtClass[] parameters = CustomJavassistUtils.toCtClass(classPool, method.getParameterTypes());
            CtClass[] exceptions = CustomJavassistUtils.toCtClass(classPool, method.getExceptionTypes());
            String methodBody = method.getReturnType().equals(Void.class) ?
                String.format(voidSrc, methodName) :
                String.format(src, methodName);

            CtMethod newMethod = CtNewMethod.make(returnType, methodName, parameters, exceptions, methodBody, ctClass);

            ctClass.addMethod(newMethod);
        }
        Class<T> targetInterfaceImplClass = (Class<T>)classPool.toClass(ctClass);

        // 4、 实例化、并为 handler 属性赋值
        T targetInterfaceImpl = targetInterfaceImplClass.newInstance();
        targetInterfaceImplClass.getField("handler").set(targetInterfaceImpl, invocationHandler);
        return targetInterfaceImpl;
    }

    /**
     * 演示使用javassist实现最基础的动态字节码生成（为一个接口动态生成一个实现类）
     */
    public void basicDemo() throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, IOException {
        ClassPool classPool = new ClassPool();
        // 相当于为ClassPool设置ClassLoader
        classPool.appendSystemPath();

        // 1、创建一个类
        final String className = "DynamicClass";
        CtClass dynamicClass = classPool.makeClass(className);

        // 2、指定实现的接口
        CtClass interfaceCtClass = classPool.get(TemplateInterface.class.getName());
        dynamicClass.addInterface(interfaceCtClass);

        // 3、创建一个方法
        final CtClass returnType = CtClass.voidType;
        final String methodName = "sayHello";
        final CtClass[] parameters = {classPool.get(String.class.getName())};
        final CtClass[] exceptions = new CtClass[0];
        final String methodBody = "{log.info(\"hello:\" + $1);}";
        CtMethod method = CtNewMethod.make(returnType, methodName, parameters, exceptions, methodBody, dynamicClass);

        dynamicClass.addMethod(method);

        // 4、实例化这个类，调用方法
        Class<?> aClass = classPool.toClass(dynamicClass);
        TemplateInterface templateInterface = (TemplateInterface) aClass.newInstance();
        templateInterface.sayHello("wmc");

        // ps：这个动态生成字节码完全可以作为xxx.Class文件保存到硬盘中
//        byte[] bytes = dynamicClass.toBytecode();
//        Files.write(Paths.get(System.getProperty("user.dir") + "/target/" + dynamicClass.getName() + ".class"), bytes);
    }

}
