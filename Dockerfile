FROM openjdk:21
WORKDIR /opt
COPY EPICTaxi/EPICTaxi/target/classes/org/example/*.jar /opt/app.jar
CMD ["java","-jar","app.jar"]
