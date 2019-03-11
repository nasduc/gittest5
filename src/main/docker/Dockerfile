FROM java:8
MAINTAINER terabits
ADD *.jar app.jar
EXPOSE 9000
ENTRYPOINT ["java","-Xmx800m","-Duser.timezone=GMT+08","-jar","/app.jar"]
