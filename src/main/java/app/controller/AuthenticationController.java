package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.ServletException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import app.encryption.EncryptionInterface;
import app.domain.User;
import app.token.FormatToken;

@RestController
@RequestMapping(value = "/autentication")
public class AuthenticationController {

    @Autowired
    private EncryptionInterface encryption;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public FormatToken login(@RequestBody User user) throws ServletException {

        if (user.getEmail() == null || user.getPassword() == null) {
            throw new ServletException("null field(s)");
        }
        try {
            /*here you have to find the user in database by email. In this code that user will be represent by userDb*/
            User userDb = new User("email@test.com", encryption.encrypt("password"));
            String encryptedPassword = encryption.encrypt(user.getPassword());
            if (userDb.getPassword().equals(encryptedPassword)) {               
                FormatToken formatToken = new FormatToken(user.getEmail());
                return formatToken;
            } else {
                throw new ServletException("invalid user");
            }
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new ServletException("encryption error");
        }

    }

}
