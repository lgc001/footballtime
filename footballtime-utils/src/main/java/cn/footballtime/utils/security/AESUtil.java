package cn.footballtime.utils.security;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

/**
 * Created by Administrator on 2016/11/29 0029.
 */
public class AESUtil {
    /** 密钥算法 */
    private static final String KEY_ALGORITHM = "AES";

    private static final String KEY = "1936168592gtujnb";//长度必须是16位

    /**
     * 加密
     *
     * @param data
     *            待加密数据
     * @param key
     *            密钥
     * @return bytes[] 加密数据
     * @throws Exception
     */
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // 还原密钥
        Key k = new SecretKeySpec(key, KEY_ALGORITHM);
        /**
         * 实例化 使用PKCS7Padding填充方式，按如下方式实现
         * Cipher.getInstance(CIPHER_ALGORITHM,"BC");
         */
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        // 初始化，设置为加密模式
        cipher.init(Cipher.ENCRYPT_MODE, k);
        // 执行操作
        return cipher.doFinal(data);
    }

    public static String encrypt(String data) throws Exception {
        return encrypt(data,"");
    }

    public static String encrypt(String data, String key) throws Exception {
        key = checkKey(key);
        byte[] dataBytes = data.getBytes("UTF-8");
        byte[] keyBytes = key.getBytes("UTF-8");
        return Base64.encodeBase64String(encrypt(dataBytes, keyBytes));
    }


    /**
     * 解密
     *
     * @param data
     *            待解密数据
     * @param key
     *            密钥
     * @return byte[] 解密数据
     * @throws Exception
     */
    private static String decrypt(byte[] data, byte[] key) throws Exception {
        // 还原密钥
        Key k = new SecretKeySpec(key, KEY_ALGORITHM);
        /**
         * 实例化 使用PKCS7Padding填充方式，按如下方式实现
         * Cipher.getInstance(CIPHER_ALGORITHM,"BC");
         */
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        // 初始化，设置解密模式
        cipher.init(Cipher.DECRYPT_MODE, k);
        // 执行操作
        return new String(cipher.doFinal(data), "UTF-8");
    }

    public static String decrypt(String data) throws Exception
    {
        return decrypt(data,"");
    }

    /**
     * 解密
     *
     * @param data
     *            待解密数据
     * @param key
     *            密钥
     * @return byte[] 解密数据
     * @throws Exception
     */
    public static String decrypt(String data, String key) throws Exception {
        if(data==null || data.isEmpty()){
            return null;
        }
        key = checkKey(key);
        byte[] keyBytes = key.getBytes("UTF-8");
        return decrypt(Base64.decodeBase64(data), keyBytes);
    }

    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
                    16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }



    /**
     * 验证key是否存在，如果不存在，使用默认的key
     *
     * @param key
     * @return
     */
    private static String checkKey(String key) {
        if (key==null || key.isEmpty()) {
            key = KEY;
        }
        return key;
    }
}
