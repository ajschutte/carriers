The Oracle JDBC JAR in lib is a required dependency. Download it (just Google it), 
then push it manually to a local Maven repository as follows:

mvn install:install-file -Dfile=ojdbc7.jar  -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=12.1.0.1 -Dpackaging=jar

This project also requires an Oracle instance. The easiest way to set up an instance is with Docker: 

https://hub.docker.com/r/wnameless/oracle-xe-11g/

DO NOT just point this project to an existing Oracle DB, since it is currently set up to drop and recreate a DB on startup. 
If you want to point it to an existing Oracle DB, modify this line: 

<property name="hibernate.hbm2ddl.auto" value="create-drop"/>

to this: 

<property name="hibernate.hbm2ddl.auto" value="validate"/>

and then set the Oracle config settings in context.xml. 

Also set the properties in gradle.properties according to your environment. 

You should now be able to build it, and deploy it to Tomcat. Run 
"gradle tasks" to get a listing of available tasks. 

There is a simple test in the test directory that invokes the REST API. 












