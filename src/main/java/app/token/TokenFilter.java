package app.token;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.filter.GenericFilterBean;

/**
 *
 * @author Raul
 */
public class TokenFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;

        String authorization = req.getHeader("Authorization");
        String key = req.getHeader("From");
        try {
            Jwts.parser().setSigningKey(key + "secret").parseClaimsJws(authorization).getBody();
        } catch (SignatureException | ExpiredJwtException e) {
            ((HttpServletResponse) servletResponse).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid or expired token");

        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

}
