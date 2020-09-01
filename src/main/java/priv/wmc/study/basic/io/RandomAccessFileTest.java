package priv.wmc.study.basic.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import priv.wmc.study.constant.FileConstant;

/**
 * <h2>RandomAccessFile</h2>
 *
 * <ul><b>介绍</b>
 *   <li>RandomAccessFile提供了对文件的读写功能。RandomAccessFile 虽然属于java.io下的类，但它不是InputStream或者OutputStream的子类</li>
 *
 *   <li>它也不同于FileInputStream和FileOutputStream。 FileInputStream 只能对文件进行读操作，而FileOutputStream 只能对文件进行写操作</li>
 *
 *   <li>与输入流和输出流不同之处就是RandomAccessFile可以访问文件的任意地方同时支持文件的读和写，并且它支持随机访问</li>
 *
 *   <li>RandomAccessFile包含InputStream的三个read方法，也包含OutputStream的三个write方法</li>
 *
 *   <li>同时RandomAccessFile还包含一系列的readXxx和writeXxx方法完成输入输出</li>
 *  </ul>
 *
 * <ul><b>应用场景</b>
 *   <li>向10G文件末尾插入指定内容，或者向指定指针位置进行插入或者修改内容</li>
 *   <li>断点续传，使用seek()方法不断的更新下载资源的位置</li>
 * </ul>
 *
 * <ul><b>其他</b>
 *   <li>RandomAccessFile包含了一个对象记录的指针，用于标识当前流的读写位置RandomAccessFile包含两个方法来操作文件记录指针</li>
 *   <li>long getFilePoint()：设置文件指针偏移，从该文件的开头测量，发生下一次读取或写入</li>
 *   <p>（前面是文档原文翻译通俗一点就是：返回文件记录指针的当前位置,不指定指针的位置默认是0）</p>
 *
 *   <li>void seek(long pos)：设置文件指针偏移，从该文件的开头测量，发生下一次读取或写入</li>
 *   <p>（前面是文档原文翻译通俗一点就是：将文件记录指针定位到pos位置）</p>
 * </ul>
 *
 * @author Wang Mincong
 * @date 2020-08-03 11:29:46
 */
@Slf4j
public class RandomAccessFileTest {

    private static final Integer BYTE_ARRAY_SIZE = 1024;

    @Test
    public void test() throws IOException {
        // RandomAccessFile 是有对 mode 参数做限制的，详情参见源码
        RandomAccessFile randomAccessFile = new RandomAccessFile("C:\\Users\\14590\\Desktop\\new.txt", "rw");

        log.info("=== 文件初始内容 ===");
        readLineAndPrint(randomAccessFile);

        // 在写之前，记录指针位置，否则将无法读出刚才写的数据
        long pointer = randomAccessFile.getFilePointer();
        write(randomAccessFile, "fuck");

        log.info("=== 文件写入数据之后的内容 ===");
        // 需要跳过换行符
        randomAccessFile.seek(pointer + 2);
        readLineAndPrint(randomAccessFile);
    }

    /**
     * 读 - 每次最多读取{@link #BYTE_ARRAY_SIZE}个字节
     *
     * @param randomAccessFile 目标文件
     */
    public void readAndPrint(RandomAccessFile randomAccessFile) throws IOException {
        byte[] buff = new byte[BYTE_ARRAY_SIZE];

        int len;
        while ((len = randomAccessFile.read(buff,0, BYTE_ARRAY_SIZE)) != -1){
            log.info(new String(buff, 0, len));
        }
    }

    /**
     * 读 - 每次读取一行
     *
     * @param randomAccessFile 目标文件
     */
    public void readLineAndPrint(RandomAccessFile randomAccessFile) throws IOException {
        String line;
        while ((line = randomAccessFile.readLine()) != null) {
            log.info(line);
        }
    }

    /**
     * 写
     *
     * @param randomAccessFile 目标文件
     * @param content 内容（UTF-8编码）
     */
    public void write(RandomAccessFile randomAccessFile, String content) throws IOException {
        /// 这样就可以
//        randomAccessFile.write((NEW_LINE + content).getBytes());

        // 这样也可以
        randomAccessFile.write(FileConstant.LINE_SEPARATOR.getBytes());
        randomAccessFile.write(content.getBytes());

        // 但是调用writeUTF方法就不行
//        randomAccessFile.writeUTF("123");
    }

}
