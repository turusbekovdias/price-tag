package kz.datcom.pricetag.factory;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

public class EncryptionPassword {

    public static String encryptByPublicKey(String publicKeyText, String password)
            throws Exception {
        X509EncodedKeySpec x509EncodedKeySpec2 = new
                X509EncodedKeySpec(Base64.decodeBase64(publicKeyText));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec2);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] result = cipher.doFinal(password.getBytes());
        return Base64.encodeBase64String(result);
    }
}
