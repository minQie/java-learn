package priv.wmc.study.jdk8.base64;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.function.BiConsumer;
import lombok.extern.slf4j.Slf4j;

/**
 * Base64：
 * 1、Base64是网络上最常见的用于传输8Bit字节码的编码方式之一，Base64就是一种基于64个可打印字符来表示二进制数据的方法。可查看RFC2045～RFC2049，上面有MIME的详细规范
 * 2、Base64编码是从二进制到字符的过程，可用于在HTTP环境下传递较长的标识信息。采用Base64编码具有不可读性，需要解码后才能阅读
 * 3、Base64由于以上优点被广泛应用于计算机的各个领域，然而由于输出内容中包括两个以上“符号类”字符（+, /, =)，
 *    不同的应用场景又分别研制了Base64的各种“变种”。为统一和规范化Base64的输出，Base62x被视为无符号化的改进版本
 *
 * static Base64.Decoder getDecoder() - 返回一个 Base64.Decoder ，解码使用基本型 base64 编码方案
 * static Base64.Encoder getEncoder() - 返回一个 Base64.Encoder ，编码使用基本型 base64 编码方案
 * static Base64.Decoder getMimeDecoder() - 返回一个 Base64.Decoder ，解码使用 MIME 型 base64 编码方案
 * static Base64.Encoder getMimeEncoder() - 返回一个 Base64.Encoder ，编码使用 MIME 型 base64 编码方案
 * static Base64.Encoder getMimeEncoder(int lineLength, byte[] lineSeparator) - 返回一个 Base64.Encoder ，编码使用 MIME 型 base64 编码方案，可以通过参数指定每行的长度及行的分隔符
 * static Base64.Decoder getUrlDecoder() - 返回一个 Base64.Decoder ，解码使用 URL 和文件名安全型 base64 编码方案
 * static Base64.Encoder getUrlEncoder() - 返回一个 Base64.Encoder ，编码使用 URL 和文件名安全型 base64 编码方案
 *
 * @author 王敏聪
 * @date 2019-08-24 17:09
 */
@Slf4j
public class Base64Demo {

    public static void main(String[] args) {
        String message = "hello world!";
        BiConsumer<Encoder, Decoder> comsumer = (encoder, decoder) -> {
            String encodeString = encoder.encodeToString(message.getBytes(StandardCharsets.UTF_8));
            log.info(encodeString);

            byte[] decodedBytes = decoder.decode(encodeString);
            String decodeString = new String(decodedBytes, StandardCharsets.UTF_8);
            log.info(decodeString);
        };

        // 编解码
        comsumer.accept(Base64.getEncoder(), Base64.getDecoder());

        // url编解码
        comsumer.accept(Base64.getUrlEncoder(), Base64.getUrlDecoder());

        // Mine编码
        comsumer.accept(Base64.getMimeEncoder(), Base64.getMimeDecoder());
    }

}
