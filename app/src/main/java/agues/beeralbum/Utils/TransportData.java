package agues.beeralbum.Utils;

/**
 * Created by rennan.agues on 8/17/2015.
 */
public class TransportData {
    private String key;
    private Object value;


    public TransportData(String key, Object value){
        this.key = key;
        this.value = value;
    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
