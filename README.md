# CAFETO

## Requirements for dev
- Build a webapp in any servlet container (preferably Tomcat).
- Write a build script in maven or gradle (preferably Gradle) to create a war file.
- The web application must be executed from the war file.
- Have a REST endpoint using an implementation of JAX-RS (preferably Jersey, but spring is also an option) that returns HTTP status code 200 if a system property is set to true, or HTTP status code 404 otherwise.
- Write unit tests for the new REST endpoint.
- Deliver the project in a source control repository, preferably a local git folder. Github is not recommended in this case, we'd rather don't make your
  results public.

## Goals
- Show your knowledge about Java webapps and the servlet api.
- Evaluate your exposure to continuous integration and build scripts.
- Demonstrate experience with unit tests, mocking and frameworks.
- Test your self-learning skills.

## Features
- Micro Services Java Rest with architecture layers.
- compareProperty method response 200 if the property to find is the same value that system.
- Unit testing.
- Repository on GitHub.

## Requirements for use
- See OpenJDK 11 on [AdoptOpenJDK](https://adoptopenjdk.net/)
- See [Apache Maven 3.8.3](https://maven.apache.org/docs/3.8.3/release-notes.html)
- See [Apache Tomcat 9](https://tomcat.apache.org/download-90.cgi)

You can also:
- Use SWAGGER for testing: http://localhost:8080/swagger-ui/#/

### Local Installation

Clone repository from Github Repository: https://github.com/ehidalgo49/cafeto.git

Compile and Build
```sh
$ cd /tmp/
$ mkdir demo
$ cd demo
$ mvn clean install
```

Install on Tomcat Server.

1. Download Apache Tomcat and unpackage it into a tomcat folder
2. Copy our WAR file from target/spring-boot-tomcat.war to the tomcat/webapps/ folder
3. From a terminal navigate to tomcat/bin folder and execute catalina.sh run (on Unix-based systems)


```sh
$ cd /tmp

$ wget http://apache.rediris.es/tomcat/tomcat-9/v9.0.10/bin/apache-tomcat-9.0.10.zip
$ unzip apache-tomcat-*.zip

$ sudo mv apache-tomcat-*/ /opt/tomcat/
$ sudo chown -R tomcat: /opt/tomcat
$ sudo chmod +x /opt/tomcat/latest/bin/*.sh

$ cp /tmp/demo/demo-1.0.0.war /opt/tomcat/latest/webapps/
$ ./opt/tomcat/latest/bin/startup.sh
```

# Methods
### compareProperty POST Request:

```json
{
  "property": "os.version",
  "value": "10.0"
}
```
### Response:

```json
HTTP: 200 / 400 / 404
```

### TODO's

- Write MORE Tests
- launch with AWS lambda or Google appEngine
- Add more validations
- Add more exceptions

License
----

APACHE


**Free Software, Hell Yeah!**
Biography:
- https://start.spring.io/


# AUTHOR:
EDWIN HIDALGO

ehidalgo49@hotmail.com

