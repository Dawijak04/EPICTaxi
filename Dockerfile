FROM openjdk:21
WORKDIR /opt
COPY target/classes/org/example/*.jar /opt/app.jar
CMD ["java","-jar","app.jar"]
