# Usa un'immagine base di OpenJDK per avere Java
FROM openjdk:17-jdk-slim

# Installa Gradle
ENV GRADLE_VERSION=7.5
RUN apt-get update && \
    apt-get install -y wget unzip && \
    wget https://services.gradle.org/distributions/gradle-$GRADLE_VERSION-bin.zip -P /tmp && \
    unzip -d /opt/gradle /tmp/gradle-$GRADLE_VERSION-bin.zip && \
    rm /tmp/gradle-$GRADLE_VERSION-bin.zip && \
    ln -s /opt/gradle/gradle-$GRADLE_VERSION/bin/gradle /usr/bin/gradle

# Aggiungi il supporto per Git, utile per sincronizzare la tua repo
RUN apt-get install -y git && \
    rm -rf /var/lib/apt/lists/*

# Imposta la directory di lavoro
WORKDIR /app

# Copia i file di progetto nella directory di lavoro
COPY . /app

# Esegui i comandi Gradle per build/test (opzionale)
RUN gradle build

# Comando di default per avviare il container
CMD ["gradle", "test"]
