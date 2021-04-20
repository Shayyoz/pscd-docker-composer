# pscd-docker-composer
Payment System Craft Demonstration docker compose files for orchestrating all services running together

## Before you start
Be sure you have installed in your machine
- Docker and Docker Compose
- Git

If you want to run any of the services with IDE, make sure it supports:
- JDK11+
- Maven 

## Run Instructions
This Repository contains the *docker-compose.yaml* file that creates the hole environment for four services:
- Payments Service (Java Application)
- Risk Engine (Java Application)
- MySql container (DB)
- RabbitMQ container (Queue)

In Addition This Repo contains the sources of the two Java Applications (Payments Service & Risk Engine) in order  
to be able running this solution with one repo

### Clone
In Order to build and Run the Project we have to choose a working directory (could be C:/git) and clone the repository:  
`pscd-docker-composer` (git clone https://github.com/Shayyoz/pscd-docker-composer.git)


If you are interested on cloning the original code base of Payments Service and Risk Engine:
* `payments-service` repo (git clone https://github.com/Shayyoz/payments-service.git)
* `risk-engine` repo (git clone https://github.com/Shayyoz/risk-engine.git)

### Docker Compose Run
Finally, with Bash Shell navigate to `WORKING_DIR/pscd-docker-composer` folder and Run `docker-compose up` command.  
The environment should be up after a few minutes.
