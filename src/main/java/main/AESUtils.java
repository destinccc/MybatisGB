package main;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/** 
 * AES加解密 
 * 
 * Created by yyh on 2015/10/9. 
 */  
public class AESUtils {  
  
    /** 
     * 密钥算法 
     */  
    private static final String ALGORITHM = "AES";  
    /** 
     * 加解密算法/工作模式/填充方式 
     */  
    private static final String ALGORITHM_STR = "AES/ECB/PKCS5Padding";  
    
    private static final String HEX_KEY = "3DRYhrv9HNiE#euD";
  
    /** 
     * SecretKeySpec类是KeySpec接口的实现类,用于构建秘密密钥规范 
     */  
    private static final  SecretKeySpec key = new SecretKeySpec(HEX_KEY.getBytes(), ALGORITHM);   
  
//    public AESUtils() {  
//        key = new SecretKeySpec(HEX_KEY.getBytes(), ALGORITHM);  
//    }  
  
    /** 
     * AES加密 
     * @param data 
     * @return 
     * @throws Exception 
     */  
    public static String encryptData(String data) throws Exception {  
        Cipher cipher = Cipher.getInstance(ALGORITHM_STR); // 创建密码器  
        cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化  
        return new BASE64Encoder().encode(cipher.doFinal(data.getBytes()));  
    }  
  
    /** 
     * AES解密 
     * @param base64Data 
     * @return 
     * @throws Exception 
     */  
    public static String decryptData(String base64Data) throws Exception{  
        Cipher cipher = Cipher.getInstance(ALGORITHM_STR);  
        cipher.init(Cipher.DECRYPT_MODE, key);  
        return new String(cipher.doFinal(new BASE64Decoder().decodeBuffer(base64Data)),"utf-8");  
    }  
  
    public static void main(String[] args) throws Exception {  
        AESUtils util = new AESUtils(); // 密钥  
//        System.out.println("cardNo:"+util.encryptData("1234")); // 加密  
        System.out.println(util.decryptData("VjOK0w7fKc7txS77+UU08mbC+aafONaRncw37QBgx/z2GIKDskVJsogc33CzUC8DdZvgY+hjj4CGRb20mu6rN9IKWfRMmCBlyIjQ9COhHPo5kDq+zAjIles0sJf8bwb5Gu6VCW1AZhG5z92KRuUP/k4kgI3Zh8lE12RjjbUhlbZJahcf1aCjokGT1Gepgj8Yq/kowJciWQYoOfRUAjO6tjDNHtJ5s0n1DtrYnGECLhom+8YpeFSssG/Jl+1gNqo2aDkv9KirQ8W1Wf34sg/D6wXCUpz680yvub1jfqnBFrq9PRRz06khedQgvjsvu5i7s6JEJYdU2hxS4Wzqhfcquw==")); // 解密
        System.out.println("mingmingmingzhumingzhu");
    }  
}  
