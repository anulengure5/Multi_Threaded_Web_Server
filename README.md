Java TCP Server: Single-Threaded, Multi-Threaded, Thread-Pooled

This project implements a TCP Server that handles client connections using three concurrency models:

Single-Threaded: Processes one client connection at a time.

Multi-Threaded: Spawns a new thread for each client connection.

Thread-Pooled: Utilizes a fixed pool of threads to efficiently manage multiple client connections.


How It Works
Connection Establishment:
The server listens for client requests and establishes connections using sockets (IP:Port).

Communication:
Once connected, the client and server exchange data over the established TCP connection.



---------------------    JMETER TEST RESULTS , TCP SAMPLER 50,000 to 1,00,000 rpm(requests per minute)   ------------------


![Screenshot 2024-12-18 232450](https://github.com/user-attachments/assets/da9b2500-43ce-4259-9118-32ce5daa8ce7)




Single-threaded for simplicity.
![Screenshot 2024-12-18 233823](https://github.com/user-attachments/assets/824f06f4-23e6-4f0a-b26f-9aaa8066ce2a)



Multi-threaded for concurrent handling.
![Screenshot 2024-12-18 234006](https://github.com/user-attachments/assets/2a149ab5-a6c5-43d3-9e73-6d7c5132fb5c)


Thread-pooling for resource optimization in high-load scenarios.
![Screenshot 2024-12-18 234227](https://github.com/user-attachments/assets/08828bd7-5005-4c2f-bdbd-2c11e0fb72f6)
