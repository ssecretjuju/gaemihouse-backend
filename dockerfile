FROM adoptopenjdk/openjdk11
#openjdk11버전 이용
ARG JAR_FILE=target/*.jar
#target의 모든 jar파일을 가리킴?
COPY ${JAR_FILE} app.jar
#이jar파일을 app.jar이라는 이름으로 복사
ENTRYPOINT ["java", "-jar", "/app.jar"]
#다음 3개의 명령어를 실행?