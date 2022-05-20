# Palindrome

Palindrome is a Java Spring Boot based REST API which can be used for calculating the longest palindrome inside a string.

## Installation

Clone the repository with [git](https://git-scm.com/).

```bash
git clone https://github.com/preznyak/palindrome.git
```
Navigate inside the application folder and compile the code and package it with [Maven](https://maven.apache.org/index.html).
```bash
mvn clean package
```
Make sure that you have [Docker](https://www.docker.com/) running on your machine and run the following commands:
```bash
docker build -t palindrome:latest .
docker run -p 8090:8080 palindrome
```
Now you have the application up and running on port 8090.

## Usage
Please import the PalindromeCollectionForDocker.postman_collection.json collection into your [Postman](https://www.postman.com/).

