package sample;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES {

    private static SecretKeySpec secretKey;
    private static byte[] key;

    /*================================KEY================================*/
    public static void setKey(String myKey)
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA3-512");
            // https://en.wikipedia.org/wiki/Secure_Hash_Algorithms     SHA-1 = BAD
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /*================================ENCRYPTION================================*/
    static String encryption(String strToEncrypt, String secret) {
        try {
            setKey(secret);

            /*        ECB - Electronic CodeBook / CBC - Cipher Blocker Chaining        */
            /*              FOR SOME REASON CBC MODE DOES NOT WORK                     */

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); //CBC/PKCS7Padding does not work
            // instantiate the Cipher object as an AES cipher with ECB mode of operation and PKCS5 padding scheme.

            /*
            COMMENT FROM STACKOVERFLOW:

            "PKCS5Padding cannot be used with AES since it is defined only for a block size of 8 bytes.
            I assume, AES/CBC/PKCS5Padding is interpreted as AES/CBC/PKCS7Padding internally.
            The only difference between these padding schemes is that PKCS7Padding has the block size as a parameter,
            while for PKCS5Padding it is fixed at 8 bytes. When the Block size is 8 bytes they do exactly the same."

            */

            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    /*================================DECRYPTION================================*/
    static String decryption(String strToDecrypt, String secret) {
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
}
