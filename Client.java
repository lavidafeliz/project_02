import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import java.util.Scanner;

public class Client {
    private static String ip;
    private static int port;
    private static final int TIMEOUT = 5000; //timeout for socket to receive response
    private static Logger logger = new Logger();

    public static void main(String[] args) throws TTransportException {
        if (args.length < 1) {
            System.out.println(("Usage put input the parameter."));
            return;
        }
        ip = args[0];
        port = Integer.parseInt(args[1]);
        String value = "";

        TTransport transport = new TSocket(ip, port, TIMEOUT);
        TProtocol protocol = new TBinaryProtocol(transport);
        KeyStoreService.Client client = new KeyStoreService.Client(protocol);
        System.out.println(logger.ts("Connected to " + ip + " " + port));
        try {
            transport.open();
            if (!client.isPrepopulated()) {
                client.put("5800", "algorithm");
                client.put("6650", "distributedSystem");
                client.put("5100", "ai");
                client.put("5500", "softwareManagement");
                client.put("5200", "database");
            }
            transport.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        while (true) {
            transport.open();
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Please enter : ");
                String operation = scanner.nextLine();
                String[] command = operation.split(" ");
                String key = command[1];

                if (command[0].equalsIgnoreCase("get")) {
                    key = command[1];
                    String returnValue = client.get(key);
                    if (returnValue.equals("NULL")) {
                        System.out.println(logger.ts("The key either does not exist or has null value"));
                    } else {
                        System.out.println(logger.ts("The value returned for key " + key + "is " + returnValue));
                    }
                } else if (command[0].equalsIgnoreCase("put")) {
                    value = command[2];
                    if (client.put(key, value)) {
                        System.out.println(logger.ts("The key:  " + key + " and value : " + value + " is put"));
                    }
                } else if (command[0].equalsIgnoreCase("delete")) {
                    if (client.deletePair(key)) {
                        System.out.println(logger.ts("The key:  " + key + " and value : " + value + " is deleted"));
                    }
                } else {
                    System.out.println("the action is not supported");
                }
                transport.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}



