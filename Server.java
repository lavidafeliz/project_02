import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

public class Server {

    private static int port;
    private static Logger logger = new Logger();

    public static void main(String[] args) {
        try {
            port = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println(logger.ts("Please specify correct port: " + e.getMessage()));
            System.exit(0);
        } catch (Exception e) {
            System.out.println(logger.ts("error"));
            System.exit(0);
        }
        Server server = new Server();
        server.startServer();
    }

    public static void startServer() {
        KeyStoreService.Processor processor = new KeyStoreService.Processor<KeyStoreService.Iface>(new KeyStoreImpl());
        try {
            TServerTransport serverTransport = new TServerSocket(port);
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));
            System.out.println(logger.ts("Server Port: " + port));
            server.serve();

        } catch (TTransportException e) {
            System.err.println(logger.ts("Error in opening TTransport socket: " + e.getMessage()));
            System.exit(0);
        }
    }
}
