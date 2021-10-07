# FRAMEWORK
professor:
curso:
data de inicio

## aula 01
### ws-framework-2

## aula 02
### ws-framework-2

hibernate 5.5.7.Final
https://hibernate.org/orm/releases/5.5/


jdbc Connector/J 8.0.26
Select Operating System:
Platanform Independent
https://dev.mysql.com/downloads/connector/j/


cria um arquivo em src/META-INF/persistence.xml

`xml
	<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" version="2.1" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd http://xmlns.jcp.org/xml/ns/persistence ">
	<persistence-unit name="JPAAula" transaction-type="RESOURCE_LOCAL">
	<provider>org.hibernate.ejb.HibernatePersistence</provider>
	<properties>
	<property name="hibernate.connection.driver_class" value="com.mysql.jdbc.Driver"/>
	<property name="hibernate.connection.username" value="root"/>
	<property name="hibernate.connection.driver_class" value="com.mysql.jdbc.Driver"/>
	<property name="hibernate.connection.password" value="password"/>
	<property name="hibernate.connection.url" value="jdbc:mysql://localhost:3306/ifam"/>
	<property name="hibernate.hbm2ddl.auto" value="update"/>
	<property name="hibernate.show_sql" value="true"/>
	<property name="hibernate.format_sql" value="true"/>
	</properties>
	</persistence-unit>
	</persistence>
`


