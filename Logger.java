import java.sql.Timestamp;
public class Logger {
    public static String ts(String log) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return (timestamp + "   " + log);
    }
}
