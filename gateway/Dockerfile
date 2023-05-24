FROM openjdk:11
MAINTAINER Thy Tran Yen <ax4409h@gmail.com>
# COPY target/*.jar app.jar

WORKDIR /app

COPY ./build/libs/gateway-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8090
CMD ["java", "-jar", "app.jar"]