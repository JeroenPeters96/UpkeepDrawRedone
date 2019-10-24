package upd.accountservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import upd.accountservice.Repo.AccountCrudRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {AccountCrudRepository.class})
public class AccountServiceMain extends SpringBootServletInitializer {

    public static void main(String[] arg) {
        SpringApplication.run(AccountServiceMain.class,arg);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(AccountServiceMain.class);
    }
}
