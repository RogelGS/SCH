/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author KSGamer
 */
public class Encrypter {
    
    private final String key ="K3Y3NCR1PT10N";
    private String encryptedText;
    
    public String encrypter(String text) {
        try {
            MessageDigest messDig = MessageDigest.getInstance("MD5");
            byte[] password = messDig.digest(this.key.getBytes("utf-8"));
            byte[] encrypBits = Arrays.copyOf(password, 24);
            
            SecretKey secKey = new SecretKeySpec(encrypBits, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, secKey);
            
            byte[] plainText = text.getBytes("utf-8");
            byte[] render = cipher.doFinal(plainText);
            byte[] base64 = Base64.encodeBase64(render);
            this.encryptedText = new String(base64);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(Encrypter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.encryptedText;
    }
    
    public String decrypter(String text) {
        try {
            byte[] message = Base64.decodeBase64(text.getBytes("utf-8"));
            MessageDigest messDig = MessageDigest.getInstance("MD5");
            byte[] cipherPassword = messDig.digest(this.key.getBytes("utf-8"));
            byte[] keyRender = Arrays.copyOf(cipherPassword, 24);
            SecretKey secKey = new SecretKeySpec(keyRender, "DESede");
            
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.DECRYPT_MODE, secKey);
            
            byte[] plainText = cipher.doFinal(message);
            
            this.encryptedText = new String(plainText, "UTF-8");
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(Encrypter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.encryptedText;
    }
}
