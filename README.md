# SpringBoot-for-beginers-with-PostgresSQL

This is similar app as previous spring boot for beginners with PostgresSQL instead of in memory db.
Steps to in memory DB to Postgres DB:
1.	Install and run pgadmin4 then you will see Pgadmin browser http://localhost:5050
Create table with id, user_name, description, targer_date, and is_completed.
2.	Add PostgresSQL dependence in pom.xml
3.	In property file add following properties. Last two properties to disable JPA (Hibernate) verification for PostgreSQL clob feature. 

spring.datasource.url= jdbc:postgresql://localhost:5432/TasksDB
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=none

# Disable feature detection by this undocumented parameter. Check the org.hibernate.engine.jdbc.internal.JdbcServiceImpl.configure method for more details.
spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults = false

# Because detection is disabled you have to set correct dialect by hand.
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQL9Dialect

4.	Then run application.
If you get sequence error, run following command in pgadmin SQL tool
CREATE SEQUENCE hibernate_sequence START 1;
        
application: http://localhost:8080
user/password: pring/spring
