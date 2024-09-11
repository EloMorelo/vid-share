# Użyj Amazon Corretto 21 jako bazowej wersji Javy
FROM amazoncorretto:21

# Argument JAR_FILE pozwala na dynamiczne ustawienie nazwy pliku JAR
ARG JAR_FILE=target/*.jar

# Ustaw katalog roboczy na /VIDSHARE
WORKDIR /VIDSHARE

# Skopiuj plik JAR do kontenera, używając zmiennej ARG
COPY ${JAR_FILE} app.jar

# Expose port (jeśli aplikacja Spring Boot działa na porcie 8080)
EXPOSE 8080

# Deklaracja autora
LABEL authors="EloMorelo"

# Komenda uruchamiająca aplikację
ENTRYPOINT ["java", "-jar", "app.jar"]
