The Oracle JDBC JAR in lib is a required dependency. Push it manually to a local Maven repository as follows:

mvn install:install-file -Dfile=ojdbc7.jar  -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=12.1.0.1 -Dpackaging=jar









