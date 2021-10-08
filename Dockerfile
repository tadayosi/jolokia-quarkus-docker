FROM adoptopenjdk/openjdk11:slim

ENV JOLOKIA_VERSION 1.7.1

LABEL jolokia.version "${JOLOKIA_VERSION}"

RUN curl -LO https://repo1.maven.org/maven2/org/jolokia/jolokia-jvm/${JOLOKIA_VERSION}/jolokia-jvm-${JOLOKIA_VERSION}.jar \
    && mv jolokia-jvm-${JOLOKIA_VERSION}.jar jolokia-jvm.jar

ADD target/quarkus-app/ quarkus-app/

CMD ["java", "-javaagent:jolokia-jvm.jar=host=*", "-jar", "quarkus-app/quarkus-run.jar"]

EXPOSE 8080 8778
