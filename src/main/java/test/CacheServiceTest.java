//package test;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//import jakarta.ws.rs.core.Response;
//
//public class CacheServiceTest {
//
//    private CacheService cacheService;
//
//    @BeforeEach
//    public void setup() {
//        cacheService = new CacheService();
//    }
//
//    @Test
//    public void testSetCache() {
//        CacheElement element = new CacheElement();
//        element.setKey("testKey");
//        element.setValue(new Person());
//        element.setTtl(60); // TTL de 60 secondes
//
//        Response response = cacheService.setCache(element);
//        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
//    }
//
//    @Test
//    public void testGetCache() {
//        CacheElement element = new CacheElement();
//        element.setKey("testKey");
//        element.setValue(new Person());
//        element.setTtl(60);
//
//        cacheService.setCache(element);
//
//        Response response = cacheService.getCache("testKey");
//        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
//    }
//
//    @Test
//    public void testGetCacheExpired() {
//        CacheElement element = new CacheElement();
//        element.setKey("testKey");
//        element.setValue(new Person());
//        element.setTtl(1); // TTL de 1 seconde
//
//        cacheService.setCache(element);
//
//        try {
//            Thread.sleep(2000); // Attendre 2 secondes pour que l'entrée expire
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//
//        Response response = cacheService.getCache("testKey");
//        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
//    }
//
//    @Test
//    public void testDeleteCache() {
//        CacheElement element = new CacheElement();
//        element.setKey("testKey");
//        element.setValue(new Person());
//        element.setTtl(60);
//
//        cacheService.setCache(element);
//        Response response = cacheService.deleteCache("testKey");
//        assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatus());
//
//        response = cacheService.getCache("testKey");
//        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
//    }
//}
