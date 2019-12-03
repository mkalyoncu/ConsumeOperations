
# Consume Operations


Consume Operations is a simple message receiving system.  
The app consumes messages which are sended from [Message Send Operations](https://github.com/mkalyoncu/MessageSendOperations) project and writes logs to stdout. 

### Contents  

EndPoint.java class has written to make channel and connection of message queue easily reachable.  

Properties file externalizes the configuration and to store the key-value pairs of message queue. It can be accessable by getProperty() method from PropertiesReader.java class.

In the project, there is a Worker.java class which receives and writes messages to stdout. Also it is implemented from Runnable interface to work with threads.

There are two workers created in the main class. When the app starts, the workers start their thread too. So the app may consume **two packages at one time**.

### Requirements  

* Java version 8 or higher.  
* RabbitMQ 3.8.x
* Apache Maven 3.6.3

### Installation

1. Download the repository files (project) from the download section or clone this project by typing in the bash the following command:  
``
git clone https://github.com/mkalyoncu/ConsumeOperations.git
``
2. Import it in Intellij IDEA.  
3. Find 'rabbitmq.properties' file under the resources directory and modify it with your information
4. Make an executable jar from the project with command below  
``
mvn install
``    
5. ``` cd target ```  
6. ``` java -jar ConsumeOperations-jar-with-dependencies.jar ```
