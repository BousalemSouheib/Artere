package artere;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Priority;
import jakarta.ejb.*;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@Singleton
@Priority(100)
@Startup
@TransactionManagement(TransactionManagementType.BEAN)
public class CacheInitializer {

    @Inject
    private CacheService cacheService;

    @PostConstruct
    public void init() {

        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
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
        System.out.println("-----------------------------");
        System.out.println(person1);
        System.out.println(person2);
        System.out.println(element1);
        System.out.println(element2);

//         Ajouter les éléments au cache

        CacheStorage.setCache(element1);
//        cacheService.setCache(element1);
//        cacheService.setCache(element2);
    }
}
