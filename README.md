## Secure Pesudo Queue
## Prerequisites
- Git
- Maven
- JDK-11

### Swagger
- The application is deployed in Heroku free tier, server will hibernate if its idle for 30 mins. First api call during hibernate will take around 30 secs to complete.
- [Click here for Swagger](https://secure-pseudo-queue-he.herokuapp.com/swagger-ui/index.html)

### Running Locally
- Run the below command
```shell
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

### Usage
- Use swagger or postman to hit /send api. Use the below cURL if needed.
```
Local:
curl --location --request POST 'http://localhost:8080/send/' \
--header 'Content-Type: application/json' \
--data-raw '{
    "2345": "123asdfghjinuytfrdexdyctvjybgftdrcxctfuvgybhlujnk;m"
}'

Heroku:
curl --location --request POST 'https://secure-pseudo-queue-he.herokuapp.com/send/' \
--header 'Content-Type: application/json' \
--data-raw '{
    "Key": "Value"
}'
```
- Processed payload will be stored in H2 DB which can be seen in the H2-Console(link given below) under MESSAGE table.
```
Local:
http://localhost:8080/h2-console

Heroku:
https://secure-pseudo-queue-he.herokuapp.com/h2-console
```
- Use the below given properties to connect to h2-console.
  ![H2 connection properties](./src/main/resources/static/H2%20console%20properties.png "H2 connection properties")
  ![H2 console](./src/main/resources/static/H2%20console.png "H2 console")