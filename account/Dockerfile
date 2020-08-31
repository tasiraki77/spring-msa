FROM openjdk:11-jdk-slim
ADD target/account-*.jar account.jar
ENV CONTAINER_NAME=account \
    PORT=9001 \
    DB_NAME=db \
    DB_USER=postgres \
    DB_PASSWD=postgres \
    OPTS_ARGS=''

ENTRYPOINT ["/bin/sh", "-c","java -jar /account.jar ${OPTS_ARGS}"]
