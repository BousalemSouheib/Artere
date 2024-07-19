package artere;

public class CacheElement {
    private String key;
    private Person value;
    private int ttl;// en secondes
    private long expiryTime;// en millisecondes

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Person getValue() {
        return value;
    }

    public void setValue(Person value) {
        this.value = value;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public long getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(long expiryTime) {
        this.expiryTime = expiryTime;
    }
}