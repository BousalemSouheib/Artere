package artere;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CacheElement {

    @JsonProperty("key")
    private String key;

    @JsonProperty("value")
    private Person value;

    @JsonProperty("ttl")
    private int ttl;// en secondes

    @JsonProperty("expiryTime")
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

    @Override
    public String toString() {
        return "CacheElement{" +
                "key='" + key + '\'' +
                ", value=" + value +
                ", ttl=" + ttl +
                ", expiryTime=" + expiryTime +
                '}';
    }

    public CacheElement() {
    }

    public CacheElement(String key, Person value, int ttl) {
        this.key = key;
        this.value = value;
        this.ttl = ttl;
    }

    public CacheElement(String key, Person value, int ttl, long expiryTime) {
        this.key = key;
        this.value = value;
        this.ttl = ttl;
        this.expiryTime = expiryTime;
    }
}