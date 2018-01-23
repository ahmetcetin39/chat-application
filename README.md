HOW TO RUN THE APPLICATION
==========================
1. This is a chat application which written using web socket. It is written in Spring Boot, 
therefore to be able to run the application, download it and open in with your IDE.
2. Run configuration will appear automatically. Furthermore it can be run by calling the main method
inside the CHatApplication class.
3. It takes a few seconds to be deployed. Then, go to localhost:8080 and take a connection.
4. Enter your username(Authentication). The chat and history panel will be seen.
5. Open another connection on localhost:8080. Enter another username. You will see the message on your first connection
about the new user in the chat.
6. You can start typing and all users in the same server will see all the messages sent.

ABOUT THE APPLICATION
---
- There is H2 Embedded database in this application. To see the tables and run queries, 
you can go to localhost:8080/h2 with default authentication parameters. 
To see more, please check application.properties.
- Every message and every user is saved to database with current timestamp. They can be checked from the H2 panel.
Consider that, it is an embedded database, so that the values are kept in memory. If the application is restarted,
all values will be gone.
- schema.sql file is used to run the create table queries at the beginning of the application.
- History panel is scrollable, you can scroll and see the previous messages.
- The messages are printed to the history panel with timestamp when the message is sent.