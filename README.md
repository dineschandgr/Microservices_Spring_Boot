# Microservices_Spring_Boot
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
1. Connect to the first mysql DB MovieCatalogDB. Create a table named movie_catalogue and insert sample data
2. Create a 2nd database named MovieInfoDB. Create a table named movie_info and insert sample data
3. Create a 3nd database named RatingsDataDB. Create a table named rating_info and insert sample data

The following configurations must be define in AWS Beanstalk Enviroment variables under software configuration

SERVER_PORT : 5000 SPRING_DATASOURCE_URL : AWS RDS MYSQL DB URL spring.datasource.username : username spring.datasource.password : password SPRING_JPA_DATABASE_PLATFORM : org.hibernate.dialect.MySQL8Dialect SPRING_JPA_HIBERNATE_DDL_AUTO : update

#AWS CodeCommit Repo Create a Code Commit Repsitory to Push the Code

#AWS CodeBuild Create a Code Build to build the code

#Create AWS Code Pipeline Create a Code Pipeline to automate the CICD

The Code Pipeline follows the below flow which is auto triggered when the code is pushed to AWS CodeCommit Repo

CodeCommit Repo -> CodeBuild -> AWS Beanstalk (It deploys the Spring Boot Jar file to the EC2 instance)
