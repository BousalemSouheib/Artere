package artere;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/cache")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CacheService {

    @ConfigProperty(name = "cache.ttl", defaultValue = "60")
    private int defaultTtl;

    private static final Map<String, CacheElement> cache = new ConcurrentHashMap<>();

    @POST
    public Response setCache(CacheElement entry) {
        int ttl = entry.getTtl() != 0 ? entry.getTtl() : defaultTtl;
        long expiryTime = System.currentTimeMillis() + ttl * 1000L;
        entry.setExpiryTime(expiryTime);
        cache.put(entry.getKey(), entry);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{key}")
    public Response getCache(@PathParam("key") String key) {
        CacheElement entry = cache.get(key);
        if (entry != null && entry.getExpiryTime() > System.currentTimeMillis()) {
            return Response.ok(entry).build();
        } else {
            cache.remove(key);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{key}")
    public Response deleteCache(@PathParam("key") String key) {
        cache.remove(key);
        return Response.noContent().build();
    }
}