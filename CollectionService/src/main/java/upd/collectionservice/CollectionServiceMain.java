package upd.collectionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import upd.collectionservice.Repo.CollectionCrudRepo;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {CollectionCrudRepo.class})
public class CollectionServiceMain extends SpringBootServletInitializer {

    public static void main(String[] arg) {
        SpringApplication.run(CollectionServiceMain.class,arg);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(CollectionServiceMain.class);
    }
}
