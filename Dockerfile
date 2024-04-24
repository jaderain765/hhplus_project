
# 베이스 이미지 설정
FROM openjdk:17-jre-slim

# 작업 디렉토리 설정
WORKDIR /app

# 호스트 시스템에서 JAR 파일을 Docker 이미지로 복사
COPY target/task.jar /app/task.jar

# 빌드 인수를 사용하여 설정 파일 경로를 전달 받습니다.
ARG CONFIG_FILE

# 설정 파일을 Docker 이미지로 복사합니다.
COPY ${CONFIG_FILE} /app/config.yaml

# Docker 이미지 빌드 시 설정 파일 경로를 인자로 전달하고, 해당 설정 파일을 애플리케이션에 전달합니다.
CMD ["java", "-jar", "your-spring-project.jar", "--spring.config.location=file:/app/config.yaml"]

# 컨테이너가 시작될 때 실행할 명령 설정
#CMD ["java", "-jar", "taskt.jar"]