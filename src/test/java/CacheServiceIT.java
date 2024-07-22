import artere.CacheElement;
import artere.Person;
import org.junit.jupiter.api.Test;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CacheServiceIT {

    private static final String BASE_URI = "http://localhost:8080/app/cache";
    private final Client client = ClientBuilder.newClient();

    @Test
    public void testSetCache() {
        CacheElement element = new CacheElement();
        element.setKey("testKey");
        element.setValue(new Person());
        element.setTtl(60);

        WebTarget target = client.target(BASE_URI);
        Response response = target.request().post(jakarta.ws.rs.client.Entity.json(element));

        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
    }

    @Test
    public void testGetCache() {
        CacheElement element = new CacheElement();
        element.setKey("testKey");
        element.setValue(new Person());
        element.setTtl(60);

        WebTarget target = client.target(BASE_URI);
        target.request().post(jakarta.ws.rs.client.Entity.json(element));

        Response response = target.path("testKey").request().get();
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    @Test
    public void testDeleteCache() {
        CacheElement element = new CacheElement();
        element.setKey("testKey");
        element.setValue(new Person());
        element.setTtl(60);

        WebTarget target = client.target(BASE_URI);
        target.request().post(jakarta.ws.rs.client.Entity.json(element));

        Response response = target.path("testKey").request().delete();
        assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatus());

        response = target.path("testKey").request().get();
        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
    }
}
