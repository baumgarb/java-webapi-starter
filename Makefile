VERSION := $(shell cat pom.xml | grep webapi-1 -A 3 | awk '/version/' | sed 's/[\/ ]//g' | sed 's/<version>//g')

compile:
	mvn compile

build:
	mvn package

run: 
	java -jar ./target/webapi-1-$(VERSION).jar

image:
	docker build -t baumgarb/webapi-1:$(VERSION) --build-arg VERSION=$(VERSION) .

run-container:
	docker run -d --rm -p 4000:3000 baumgarb/webapi-1:$(VERSION)

app-version:
	@echo "The app version is $(VERSION)"