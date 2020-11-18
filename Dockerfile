FROM maven:3.6.3-jdk-11 AS builder

COPY ./src/ /root/src
COPY ./pom.xml /root/
COPY ./checkstyle.xml /root/
WORKDIR /root
RUN mvn package
RUN java -Djarmode=layertools -jar /root/target/OMP2-1.0-SNAPSHOT.jar list
RUN java -Djarmode=layertools -jar /root/target/OMP2-1.0-SNAPSHOT.jar extract
RUN ls -l /root

FROM openjdk:11.0.6-jre

ENV TZ=UTC
ENV DB_IP=ec2-54-155-22-153.eu-west-1.compute.amazonaws.com
ENV DB_PORT=5432
ENV DB_USER=bzawfwtwehxxoy
ENV DB_PASSWORD=c4ba7dbda35c8b1547bc92b4ae8cd1728ac17d5cab5869fa6c2df0e133ba69e6
ENV DB_DBNAME=dajd1elre33pl2


COPY --from=builder /root/dependencies/ ./
COPY --from=builder /root/snapshot-dependencies/ ./

RUN sleep 10
COPY --from=builder /root/spring-boot-loader/ ./
COPY --from=builder /root/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher","-XX:+UseContainerSupport -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMFraction=1 -Xms512m -Xmx512m -XX:+UseG1GC -XX:+UseSerialGC -Xss512k -XX:MaxRAM=72m"]