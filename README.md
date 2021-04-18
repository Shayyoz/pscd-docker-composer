# pscd-docker-composer
Payment System Craft Demonstration docker compose files for orchestrating all services running together

## Before you start
Be sure you have installed in your machine
- JDK11+
- Maven 
- Docker and Docker Compose
- Git

## Run Instructions
This Repository contains the *docker-compose.yaml* file that create the hole environment for four services:
- Payments Service (Java Application)
- Risk Engine (Java Application)
- MySql container (DB)
- RabbitMQ container (Queue)
### Clone
In Order to build and Run the Project we have to choose a working directory (could be C:/git) and clone those Three Repositories:
1. `pscd-docker-composer` (this repo) (git clone https://github.com/Shayyoz/pscd-docker-composer.git)
2. `payments-service` repo (git clone https://github.com/Shayyoz/payments-service.git)
3. `risk-engine` repo (git clone https://github.com/Shayyoz/risk-engine.git)

### Build<a name="build"></a>
We need to build the two Java applications(`payments-service`, `risk-engine`) in order to create jar executable files 
-  Open every project as Existing Maven Project in any IDE (I personally use Intellij)
-  Run Maven's `mvn package` command
-  The same result can be achieved also using CMD while navigating the repositories folder and 
   run `mvn clean package` command
-  Make sure that a new Jar file has been created in /target folder   
   
### Docker Image Build
Now we have to build the docker image for the two Java applications so that the docker composer
will have all necessary images to create the environment
- navigate to each of the projects in bash (`WORKING_DIR/payments-system` and `WORKING_DIR/risk-engine`)
- Run the Docker command `docker build -t <Project-name> .`

### Docker Compose Run
Finally, with bash navigate to `WORKING_DIR/pscd-docker-composer` folder and Run `docker-compose up` command.
The environment should be up in less than a minute.
