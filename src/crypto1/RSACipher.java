/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto1;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.bouncycastle.jce.provider.asymmetric.ec.KeyFactory;
import org.bouncycastle.util.encoders.Base64;
import sun.misc.IOUtils;


/**
 *
 * @author Danh Cooper
 */
public class RSACipher {
    public String encrypt(String rawText, String publicKeyPath, String transformation, String encoding)
            throws IOException, GeneralSecurityException {
 
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(IOUtils.toByteArray(new FileInputStream(publicKeyPath)));
 
        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(Cipher.ENCRYPT_MODE, KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec));
 
        return Base64.encodeBase64String(cipher.doFinal(rawText.getBytes(encoding)));
    }
    public String decrypt(String cipherText, String privateKeyPath, String transformation, String encoding)
            throws IOException, GeneralSecurityException {
 
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(IOUtils.toByteArray(new FileInputStream(privateKeyPath)));
 
        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(Cipher.DECRYPT_MODE, KeyFactory.getInstance("RSA").generatePrivate(pkcs8EncodedKeySpec));
 
        return new String(cipher.doFinal(Base64.decodeBase64(cipherText)), encoding);
    }
}
