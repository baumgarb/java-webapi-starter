# Introduction

This tiny Maven project is a starter project for a Java web API based on Javalin. It comes with a arguably handy `Makefile` that allows you to compile, build and run the application. It also provides targets for building a Docker image and running containers from it. The `Makefile` uses the artifact version tracked in the `pom.xml` for all of this, which includes building and tagging the Docker image. 

# Usage

```bash
# Build the application jar
make build

# Run the jar we just built
make run

# Try out the API
curl http://localhost:3000/api/v1/version
```

# Make target

```bash
# Disclaimer
# ----------
# x.y.z always refers to the Maven package version of your application. The Makefile extracts the <version>...</version> and populates it where necessary

# Compile the project
make compile

# Build a .jar which ends up in ./target/webapi-1-x.y.z.jar
make build

# Runs the jar which has to be created with 'make build' first
make run

# Build a Docker image which has to be created with 'make build' first. See Dockerfile for more details on the Docker image itself. 
make image

# Fires up a new container based on the image with tag x.y.z
make run-container
```



