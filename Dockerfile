FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test_jrmy_bot
ENV BOT_TOKEN=1375780501:1980396521:AAHTtjwf-mT1jRvkFodzqo_5VVEVnlxuQZk
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]