FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test_jrmy_bot
ENV BOT_TOKEN=1375780501:1980396521:AAHTtjwf-mT1jRvkFodzqo_5VVEVnlxuQZk
ENV BOT_DB_USERNAME=root
ENV BOT_DB_PASSWORD=root
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dspring.datasource.password=${BOT_DB_PASSWORD}", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-Dspring.datasource.username=${BOT_DB_USERNAME}", "-jar", "app.jar"]