package app.token;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Raul
 */
public class FormatToken {

    private String token;

    public FormatToken(String key) {         
        this.token = Jwts
                .builder()
                .signWith(SignatureAlgorithm.HS512, key + "secret")
                .setExpiration(new Date(System.currentTimeMillis() + 10 * 60 * 1000))//ten minutes
                .compact();

    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.token);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FormatToken other = (FormatToken) obj;
        return Objects.equals(this.token, other.token);
    }

    @Override
    public String toString() {
        return "FormatToken{" + "token=" + token + '}';
    }

}
