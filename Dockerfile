FROM busybox
ADD ./target/*.jar /app/application.jar
#CMD ["java","-jar","/app/application.jar"]
