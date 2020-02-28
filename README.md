# project_02
This project uses Apache Thrift software framework for RPC communication.
The server serves as a Key-Value data server which support multi-thread. The client could get, put, delete to server concurrently. It is implemented with Apache Thrift. 

##Instructions to execute
1. thrift -gen java KeyStoreService.thrift . It would generate code into KeyStoreService.java file 
2. java -jar Server.jar <port number>  
3. java -jar Client.jar <ip> <port number>  
  in client console, it would ask user to input operation parameters, keys and values. 
  
For example:   
1. java -jar Server.jar 8000
2. java -jar Client.jar localhost 8000
   the console would sugguest user to input 
   - to put data: put 5800 algorithm
   - to get data: get 5800
   - to delete data: delete 5800  
3. Result:  
   Server Side: 
   2020-02-27 17:31:10.256   Server Port: 8000  
2020-02-27 17:32:02.986    data store is empty, need to prepopulate  
2020-02-27 17:32:03.001    put successful. Key:  5800 Value:  algorithm  
2020-02-27 17:32:03.003    put successful. Key:  6650 Value:  distributedSystem  
2020-02-27 17:32:03.003    put successful. Key:  5100 Value:  ai  
2020-02-27 17:32:03.004    put successful. Key:  5500 Value:  softwareManagement  
2020-02-27 17:32:03.004    put successful. Key:  5200 Value:  database  
2020-02-27 17:32:18.237    put successful. Key:  5800 Value:  algorithm  
2020-02-27 17:32:28.644    put successful. Key:  6650 Value:  distributedSystem  
2020-02-27 17:32:34.276    put successful. Key:  5100 Value:  ai  
2020-02-27 17:32:48.733    put successful. Key:  5500 Value:  softwareManagement  
2020-02-27 17:32:57.429    put successful. Key:  5200 Value:  database  
2020-02-27 17:33:12.087    get successful. Key:  5800 Value:  algorithm  
2020-02-27 17:33:16.799    get successful. Key:  6650 Value:  distributedSystem  
2020-02-27 17:33:19.429    get successful. Key:  5100 Value:  ai  
2020-02-27 17:33:21.413    get successful. Key:  5500 Value:  softwareManagement  
2020-02-27 17:33:26.293    get successful. Key:  5200 Value:  database  
2020-02-27 17:33:41.087    delete successful. Key:  5800 Value:  algorithm  
2020-02-27 17:33:45.566    delete successful. Key:  6650 Value:  distributedSystem  
2020-02-27 17:33:51.319    delete successful. Key:  5100 Value:  ai  
2020-02-27 17:33:55.742    delete successful. Key:  5500 Value:  softwareManagement  
2020-02-27 17:33:59.166    delete successful. Key:  5200 Value:  database  

Client Side  

2020-02-27 17:32:02.918   Connected to localhost 8000  
Please enter : put 5800 algorithm  
2020-02-27 17:32:18.237   The key:  5800 and value : algorithm is put  
Please enter : put 6650 distributedSystem  
2020-02-27 17:32:28.645   The key:  6650 and value : distributedSystem is put  
Please enter : put 5100 ai  
2020-02-27 17:32:34.276   The key:  5100 and value : ai is put  
Please enter : put 5500 softwareManagement  
2020-02-27 17:32:48.733   The key:  5500 and value : softwareManagement is put  
Please enter : put 5200 database  
2020-02-27 17:32:57.43   The key:  5200 and value : database is put  
Please enter : get 5800  
2020-02-27 17:33:12.089   The value returned for key 5800is algorithm  
Please enter : get 6650  
2020-02-27 17:33:16.8   The value returned for key 6650is distributedSystem  
Please enter : get 5100  
2020-02-27 17:33:19.429   The value returned for key 5100is ai  
Please enter : get 5500  
2020-02-27 17:33:21.413   The value returned for key 5500is softwareManagement  
Please enter : get 5200  
2020-02-27 17:33:26.294   The value returned for key 5200is database  
Please enter : delete 5800  
2020-02-27 17:33:41.089   The key:  5800 and value : database is deleted  
Please enter : delete 6650  
2020-02-27 17:33:45.566   The key:  6650 and value : database is deleted  
Please enter : delete 5100  
2020-02-27 17:33:51.319   The key:  5100 and value : database is deleted  
Please enter : delete 5500  
2020-02-27 17:33:55.742   The key:  5500 and value : database is deleted  
Please enter : delete 5200  
2020-02-27 17:33:59.166   The key:  5200 and value : database is deleted  
Please enter :   

