package app.encryption;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Raul
 */
public interface EncryptionInterface {
    
    public String encrypt(String password)throws NoSuchAlgorithmException, UnsupportedEncodingException;
    
}
