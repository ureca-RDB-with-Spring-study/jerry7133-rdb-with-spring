FROM gradle:8.7-jdk21-alpine AS builder

WORKDIR /app

COPY . .

RUN chmod +x ./gradlew

RUN ./gradlew bootJar -x test --no-daemon

FROM eclipse-temurin:21-jdk-alpine

RUN apk update && apk add --no-cache \
    vim \
    fzf \
    unzip \
    busybox-extras \
    openssh \
    curl \
    zsh \
    git \
    bat \
    tmux \
    sed \
    zsh-vcs 

RUN echo "/bin/zsh" >> /etc/shells 

RUN sed -i 's|/bin/ash|/bin/zsh|' /etc/passwd 

RUN curl -L https://raw.github.com/ohmyzsh/ohmyzsh/master/tools/install.sh | sh 

RUN echo "alias ll='ls -l | bat --color=always'" >> ~/.bashrc 
RUN sed -i 's/robbyrussell/agnoster/g' ~/.zshrc
RUN echo "alias ll='ls -al | bat --color=always'" >> ~/.zshrc
RUN echo "alias vi='vim'" >> ~/.zshrc
RUN echo "alias baf='find / -type f | fzf --preview=\"bat --color=always {}\"'" >> ~/.zshrc
RUN echo "alias vif='vim \$(find / -type f | fzf --preview=\"bat --color=always --hidden {}\")'" >> ~/.zshrc

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]