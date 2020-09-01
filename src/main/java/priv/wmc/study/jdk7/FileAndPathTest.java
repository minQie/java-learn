package priv.wmc.study.jdk7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * jdk1.7 java.nio.file 包
 *
 * @author Wang Mincong
 * @date 2020-07-26 10:30:58
 */
@Slf4j
public class FileAndPathTest {

    @Test
    public void test() {
        Path path = Paths.get("");

        log.info("Number of Nodes:{}", path.getNameCount());
        log.info("File name:{}", path.getFileName());
        log.info("File Root:{}", path.getRoot());
        log.info("File Parent:{}", path.getParent());

        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
