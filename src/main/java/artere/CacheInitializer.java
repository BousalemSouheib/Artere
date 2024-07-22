package artere;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.*;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.sql.DataSource;
import java.sql.Connection;

@Named
@Singleton
@Startup
public class CacheInitializer {

    @Inject
    private CacheService cacheService;

    @Inject
    @ConfigProperty(name = "cache.load.initial.data", defaultValue = "false")
    private Boolean initializeData;

    @PersistenceContext(unitName = "cachePU")
    private EntityManager em;

    @PostConstruct
    public void init() {
        if (initializeData != null && initializeData ) {

            Person person1 = new Person("Souheib", "BOUSALEM");
            Person person2 = new Person("Aryem", "BOUSALEM");

            CacheElement element1 = new CacheElement("000001", person1, 120);
            CacheElement element2 = new CacheElement("000002", person2, 180);

            cacheService.setCache(element1);
            cacheService.setCache(element2);
        }
    }
}
