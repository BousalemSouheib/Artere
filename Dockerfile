FROM maven:3.9.6-amazoncorretto-21 as builder

RUN mkdir -p /root/.m2 && mkdir /root/.m2/repository

WORKDIR /usr/src/app/

COPY pom.xml .

RUN mvn verify --fail-never

COPY . .

RUN mvn clean package

FROM payara/server-full:6.2023.12-jdk21

COPY --from=builder /usr/src/app/target/cache-system.war /opt/payara/deployments/cache-system.war