FROM gcr.io/distroless/java17-debian12
ARG VERSION
ENV VERSION=$VERSION
WORKDIR /app
COPY ./target/webapi-1-$VERSION.jar ./webapi-1.jar
CMD ["webapi-1.jar"]
