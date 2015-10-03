/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.KeyGenerator;

/**
 *
 * @author Danh Cooper
 */
public class RSAKeyPair {
    private int keyLength;
    private PrivateKey privateKey;
    private PublicKey publicKey;
    
    public RSAKeyPair(int keyLength) throws GeneralSecurityException                               
    {
        this.keyLength = keyLength;
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(this.keyLength);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        privateKey = keyPair.getPrivate();
        publicKey = keyPair.getPublic();               
    }
    public PrivateKey getPrivateKey(){
        return privateKey;
    }
    public PublicKey getPublicKey(){
        return publicKey;
    }
    public void saveToFileSystem(String privateKeyPathName, String publicKeyPathName) throws IOException{
        FileOutputStream privateKeyOutputStream = null;
        FileOutputStream publicKeyOutputStream = null;
        try {
            File privateKeyFile = new File(privateKeyPathName);
            File publickeyFile = new File (publicKeyPathName);
        
            privateKeyOutputStream = new FileOutputStream(privateKeyFile);
            privateKeyOutputStream.write(privateKey.getEncoded());
            
            publicKeyOutputStream = new FileOutputStream(publickeyFile);
            publicKeyOutputStream.write(publicKey.getEncoded());            
        }
        catch(IOException e){
            throw e;
        }finally {
         
            try {
                 
                if (privateKeyOutputStream != null) {
                    privateKeyOutputStream.close();
                }
                if (publicKeyOutputStream != null) {
                    publicKeyOutputStream.close();
                }   
                 
            } catch(IOException ioException) {
                throw ioException;
            }
        }       
    }
    
}
