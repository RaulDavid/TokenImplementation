package app.encryption;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Raul
 */

@Component
public class Encryption implements EncryptionInterface {

    @Override
    public String encrypt(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = algorithm.digest(("secret" + password).getBytes("UTF-8"));
        StringBuilder encryptedPassword = new StringBuilder();

        for (byte b : messageDigest) {
            encryptedPassword.append(String.format("%02X", 0xFF & b));
        }

        return encryptedPassword.toString();

    }

}
