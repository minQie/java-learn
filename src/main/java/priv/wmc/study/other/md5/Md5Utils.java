package priv.wmc.study.other.md5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Wang Mincong
 * @date 2020-07-21 19:05:33
 */
@Slf4j
public final class Md5Utils {

    private Md5Utils() {}

    public static String md5(String plainText) throws NoSuchAlgorithmException {
        byte[] secretBytes = MessageDigest.getInstance("md5").digest(plainText.getBytes());
        String md5code = new BigInteger(1, secretBytes).toString(16);
        return String.format("%32s", md5code).replace(' ', '0');
    }

}
