package upd.edhrecservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class EdhrevServiceMain extends SpringBootServletInitializer {

    public static void main(String[] arg) {
        SpringApplication.run(EdhrevServiceMain.class, arg);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(EdhrevServiceMain.class);
    }
}
