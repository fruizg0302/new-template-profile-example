# Profile Service

Profile Service is responsible to << CHANGE ME  write here the motivation and responsibility to create this project >> 

This project was build based on PaloIT templates. 

## Requirements

### Software
* Java JDK >=17
* NodeJS (to use httpyac cli)

### IDE
* Set up code formatting template (root folder intellij-java-google-style.xml)
* Change properties encoding to UTF-8
* Follow the PaloIT setup guide https://paloit.atlassian.net/wiki/spaces/PAPA/pages/2152661057/IDE+Setup

### CLI
* HTTP Yac.
````bash
npm install -g httpyac
````

## Usage
The application has the next Spring Profiles that configure the application behavior

| Profile  | Behavior                           |
|----------|------------------------------------|
| develop  | Active typical one line log format |

- Compile
```bash
mvn clean install
```

- Run Application
```bash
mvn spring-boot:run -pl profile-service-server -Dspring-boot.run.profiles=develop
```

- Run Integration Tests
```bash
mvn failsafe:integration-test
```

- Build Image
```bash
mvn clean install
mvn spring-boot:build-image pl profile-service-server
```

- Test API's and/or GRPC Services
```bash
httpyac send http-collection/ --all
```
## Development Conduct Guide
- Make sure before any commit your code use the formatting template `intellij-java-google-style.xml`
- Document your `@ConfigurationProperties` in code and [Properties Markdown](PROPERTIES.md) you can follow the Spring Guide
[ConfigurationProperties Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#appendix.configuration-metadata.annotation-processor.automatic-metadata-generation)
this will let external people know what configurations are available.
- Document in this readme new **Spring profiles**

### About **liquibase**
- Scripts file name have start with `db.` and include a timestamp to order the files the time stamp have to follow the pattern `%Y%m%d%H%M`. You can use the next unix script to generate the name
```bash
date +db.%Y%m%d%H%M
```
- Scripts have to include attributes
  - `id` with a unique identifier suggested ULID. This is an [Online ULID](https://ulidgenerator.com/)
  - `author` with the email of the author
  - `comment` with a short description of the change
  - `tagDatabase` to be able to do rollback during production deployment