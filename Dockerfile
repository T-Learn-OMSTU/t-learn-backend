FROM gradle:8.14-jdk21

WORKDIR /app

COPY . .

CMD ["./gradlew", "generateDatabase", "bootRun"]