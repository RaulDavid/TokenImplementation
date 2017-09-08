package app;

import app.token.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
/**
 *
 * @author Raul
 */
@SpringBootApplication
public class App {

    @Bean
    public FilterRegistrationBean jwtFilter() {
        FilterRegistrationBean frb = new FilterRegistrationBean();
        frb.setFilter(new TokenFilter());
        frb.addUrlPatterns("/checked/*");

        return frb;
    }

    public static void main(String... args) {
        SpringApplication.run(App.class, args);

    }
}
