# Microservices Communication and Service Discovery
Micro Services Application using Spring Boot and Spring Cloud

This Project uses an application for Service Discovery

1. Eureka Service Discovery Server (runs on port 8761)

And three microservices which are Eureka Clients

1. Movie Catalog Service (runs on port 8081)
2. Movie Ratings Data Service (runs on port 8082)
3. Movie Info Service (runs on port 8083)

Movie Catalog Service discovers 2 other microservices and communicates with them using RestTemplate

Requirements :

#add pom.xml file You need to add pom.xml with the maven dependencies

#Create AWS RDS MySQL DB or a local MYSQL DB

#To Create a RDS MYSQL Database
1. Create an RDS mysql 1st database named MovieCatalogDB (only 1 DB can be created from AWS RDS Console per service)
2. Set the RDS DB to public accessibility to YES (just for testing purposes. in real projects its in a private VPC and can be used only from a authorized VPC)
3. Copy the DB endpoint url, user name and pwd
4. Open the Port 3306 for your local machine IP

#Use the DB tool Sqlectron
1. Connect to the first mysql DB MovieCatalogDB creating from AWS RDS console. Create a table named movie_catalogue and insert sample data
2. Create a 2nd database named MovieInfoDB. Create a table named movie_info and insert sample data
3. Create a 3rd database named RatingsDataDB. Create a table named rating_info and insert sample data

#Update the DB credentials and Sever Port in application.properties file for every microservices project

1. Start the Discovery Application Server Application first which runs on port 8761
2. Run all three microservices which are registered which the Eureka Server
3. Access http://localhost:8761 to see Eureka Discovery Server console and verify that all 3 microservices are up and registered
4. Access http://localhost:8081/catalog/user_name to access Movie Catalog Microservice
5. Access http://localhost:8082/movies/movie_id to access Movie Info Service
6. Access http://localhost:8083/ratingsdata/user/user_name to access Ratings Data Service
7. Microservice running on port 8081 consumes the services running on port 8082 and port 8083 
