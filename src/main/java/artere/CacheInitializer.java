package artere;

import jakarta.enterprise.context.ApplicationScoped;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;

@ApplicationScoped
public class CacheInitializer {

    @Inject
    private CacheService cacheService;

    @PostConstruct
    public void init() {
        // Créer des objets Person
        Person person1 = new Person();
        person1.setFirstname("John");
        person1.setLastname("Doe");

        Person person2 = new Person();
        person2.setFirstname("Jane");
        person2.setLastname("Smith");

        // Créer des objets CacheElement
        CacheElement element1 = new CacheElement();
        element1.setKey("person1");
        element1.setValue(person1);
        element1.setTtl(120); // TTL de 120 secondes

        CacheElement element2 = new CacheElement();
        element2.setKey("person2");
        element2.setValue(person2);
        element2.setTtl(180); // TTL de 180 secondes

        // Ajouter les éléments au cache
        cacheService.setCache(element1);
        cacheService.setCache(element2);
    }
}
