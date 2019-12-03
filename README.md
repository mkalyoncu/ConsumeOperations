# Consume Operations


Consume Operations is a simple message receiving system.  
The app consumes messages which are sended from [Message Send Operations](https://github.com/mkalyoncu/MessageSendOperations) project.  
In the project, there is a Worker.java class that does the receiving and also implemented from Runnable interface. I created two workers and when the app starts, the two workers are start their thread too. So the app may consume **two packages at one time**.

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
4. Run the app or make an executable jar from the project with command below  
``
mvn install
``    
5. ``` cd target ```  
6. ``` java -jar MessageSendOperations-jar-with-dependencies.jar ```
