package priv.wmc.study.jdk7;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;

/** 
 * try-with-resources 是 JDK 7 中一个新的异常处理机制，它能够很容易地关闭在 try-catch 语句块中使用的资源。
 * 所谓的资源（resource）是指在程序完成后，必须关闭的对象。try-with-resources 语句确保了每个资源在语句结束时关闭。
 * 所有实现了 java.lang.AutoCloseable 接口（其中，它包括实现了 java.io.Closeable 的所有对象），可以使用作为资源。
 * 
 * 【强制】finally块必须对资源对象、流对象进行关闭，有异常也要做try-catch。 
 * 说明：如果JDK7及以上，可以使用try-with-resources方式。
 * 
 * 注意：是帮你自动在try之后关闭资源，不是自动帮你处理异常（错误的启蒙认知 - 尴尬，怎么才能认知成这样）
 * 
 * @author Wang Mincong
 * @date 2020-05-02 17:47
 */
public class TryWithResourcesTest {

    @Test
    public void demo() throws IOException {
        tryWithResourcesExample1();
    }

    /**
     * jdk1.7之前
     */
    public void normal() throws IOException {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File(""));
            // 巴拉巴拉操作
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
        	}
		}
	}
	
	/**
	 * jdk1.7以后
	 * 
	 * “resources”的“s”：try可以声明多个，分号隔开
	 * 引出问题：类比上面，在tryWithResources语句下面定义和小括号中的变量名一样的变量会不会提示错误：没有错误？
	 * （实现原理 - 对编译生成class进行反编译就知道了）
	 */
	public void tryWithResourcesExample1() throws IOException {
		try (FileInputStream fileInputStream = new FileInputStream(new File(""))) {
			// 巴拉巴拉操作
		}
		
		@SuppressWarnings("unused")
		FileInputStream fileInputStream = null;
	}
	
	/**
	 * 引出jdk9的变化
	 */
	public void tryWithResourcesExample2() throws IOException {
		FileInputStream fileInputStream = new FileInputStream(new File(""));
		
		try (FileInputStream fileInputStream2 = fileInputStream) {
			// 巴拉巴拉操作
		}
		
		// jdk9中可以像下边这样
//		try (fileInputStream2) {
//			// 巴拉巴拉操作
//		}
	}
	
}
