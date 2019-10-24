package upd.deckservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import upd.deckservice.Repo.DeckCrudRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {DeckCrudRepository.class})
public class DeckServiceMain extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DeckServiceMain.class);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(DeckServiceMain.class);
    }
}
