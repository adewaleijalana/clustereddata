FROM java:8
VOLUME /tmp
EXPOSE 8989
ADD /clustereddata-api/target/clustereddata-api-0.0.1-SNAPSHOT.jar clustereddata-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","clustereddata-api-0.0.1-SNAPSHOT.jar"]