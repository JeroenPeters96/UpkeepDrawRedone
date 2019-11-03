package upd.cardservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import upd.cardservice.Repo.CardCrudRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {CardCrudRepository.class})
public class CardServiceMain extends SpringBootServletInitializer {

    public static void main(String[] arg) {
        SpringApplication.run(CardServiceMain.class,arg);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(CardServiceMain.class);
    }
}
