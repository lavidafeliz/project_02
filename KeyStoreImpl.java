import org.apache.thrift.TException;
import java.util.HashMap;
import java.util.Map;

public class KeyStoreImpl implements KeyStoreService.Iface {
    //private static final String logFile = "store.log";
    private Map<String, String> store = new HashMap<String, String>();
    private static Logger logger = new Logger();

    public boolean put(String key, String value) throws TException {
        store.put(key,value);
        if (store.get(key).equals(value)) {
            System.out.println(logger.ts(" put successful. Key:  " + key + " Value:  " + value));
            return true;
        }
        else{
            return false;
        }
    }

    public String get(String key) throws TException {
        String value = store.get(key);
        System.out.println(logger.ts(" get successful. Key:  " + key + " Value:  " + value));
        return value;
    }

    public boolean deletePair(String key) throws TException {
        String value = store.get(key);
        if (!store.containsKey(key)) {
            System.out.println(logger.ts("no this key. hash map is empty"));
            return false;
        }
        store.remove(key);
        System.out.println(logger.ts(" delete successful. Key:  " + key + " Value:  " + value));
        return true;
    }

    public boolean isPrepopulated()throws TException {
        if (store.isEmpty()) {
            System.out.println(logger.ts(" data store is empty, need to prepopulate" ));
            return false;
        }
        return true;
    }

}