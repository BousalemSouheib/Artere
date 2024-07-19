package artere;

import jakarta.enterprise.context.ApplicationScoped;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;


@Singleton
public class CacheInitializer {

    @Inject
    private CacheService cacheService;

    @PostConstruct
    public void init() {
        // Créer des objets Person
        Person person1 = new Person();
        person1.setFirstname("Souheib");
        person1.setLastname("BOUSALEM");

        Person person2 = new Person();
        person2.setFirstname("Aryem");
        person2.setLastname("BOUSALEM");

        // Créer des objets CacheElement
        CacheElement element1 = new CacheElement();
        element1.setKey("000001");
        element1.setValue(person1);
        element1.setTtl(120);

        CacheElement element2 = new CacheElement();
        element2.setKey("00002");
        element2.setValue(person2);
        element2.setTtl(180);

        // Ajouter les éléments au cache
        cacheService.setCache(element1);
        cacheService.setCache(element2);
    }
}
