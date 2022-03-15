# TestApplicationJava
## Employee Application

I called it Employee Application, couldn't find a better name. It is a desktop app. The java file with this name is the main file where everything starts. Class names correspond to the names of their parent clasess from (e.g. EmployeeMainBorderPane -> inherits BorderPane class).

**build.gradle** contains necessary dependencies and plugins.

**overview package** consists of view classes. App is divided into "employee" and "company" tabs (all files are in the corresponding packages).

**model package** is where the data are retrieved and related objects are stored. All sql statements are the prepared statements for security reasons (e.g. against SQL injection attacks). Moreover, correctness of the fields' lengths, duplication of values (considering the spaces) and emptiness checks are performed whenever the information is going to be stored.

**database files** are stored in the docker directory. `docker-compose.yaml` file will create a docker image of PostgreSQL and Adminer panel to control from the web (localhost:8080). Alternatively pgAdmin can also be used to connect to the docker container. `data` folder is copy of the container volume while the `EmployeeDB.sql.gz` file is an exported sql file.

### Entity Relationship diagram
![Entity Relationship diagram](./ER_diagram.pdf)

> Note: I shouldn't have included the .env file. It is for testing purposes. 
