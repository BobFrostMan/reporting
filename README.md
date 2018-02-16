# App-statistics
Some reporting solutions for training purposes.

# Installation

### Pre-steps
+ install [Maven](https://maven.apache.org/download.cgi) and add it in environment variables.
+ install [MongoDb](https://www.mongodb.com/download-center#community/) if you have not done this before. 
Configuration for database you can find in **../reporting/app-statistics/src/main/resources/database.properties**.
+ (optional) For the correct integration IntelliJ with Lombok project you should be install the [Lombok plug-in](#Lombok).

### Start application
To start App-statistics application you should be execute following steps:
+ **cd ../reporting/app-statistics**
+ **mvn clean tomcat7:run-war**
Tomcat server with application will be start on [http://localhost:8090](http://localhost:8090).

### Stop application
To stop App-statistics application you should be execute following steps:
+ **cd ../reporting/app-statistics**
+ **mvn tomcat7:shutdown**

# Detailed guide

### <a name="Lombok"></a> Lombok project
To install Lombok plugin in IntelliJ you should be execute following steps:
+ open IntelliJ
+ press **Ctrl + Alt + S** buttons.
+ find **plugins** directory and open it.
+ click **Browse repositories** button.
+ enter **lombok** in the search box.
+ install **Lombok plugin**
+ restart IntelliJ
