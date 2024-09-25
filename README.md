# Streaming API

## Setup 🛠️
If you are interested in cloning this repository, here is a brief list of suggestions/item that you have to complete in order to run the
project sucessfully in a local envirmoment.

First of all the requirements:

- JDK Java 17
- A Database Manager

The following step is the creation of an enviroment file `.env`:
```
POSTGRES_HOST=
POSTGRES_PORT=
POSTGRES_USER=
POSTGRES_PASSWORD=
POSTGRES_DB=

JWT_PASSWORD=
```

Now synchronize all the project dependencies by accessing to the pom.xml file. If you are using IntelliJ just synchronize the file by one click.

## Database
The next step is setting up the DB. For this scenario I used Docker to instantiate a container with the image of PostgreSQL:
```
docker run -d \                                                                              
    --name your_db \
    -p 5432:5432 \
    -e POSTGRES_DB=your_db_name \
    -e POSTGRES_USER=your_user \
    -e POSTGRES_PASSWORD=secret_password \
    postgres:16-alpine \
```

**The database credentials has to match the `.env` file!**

### Table Creation
As springboot creates the tables when it is run for the first time, run the project and it will compile and create all the necessary beans and tables.


### Tests with Data of Inserts
Using your preferred DB Manager (in my case DBeaver) connect to the DB and execute the inserts stored in `\src\main\resources\inserts.sql`,
now you are up to test all the features of this API.

All the endpoints and some test values are showed in a postman collection file: `Streaming API.postman_collection.json` 
and also can find the Swagger UI with the documentation of the endpoints in local once the project is up in the following url: [localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/).

