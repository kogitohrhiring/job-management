# job-management
Repository for Job Management microservice

## Run 

Go to job-management folder and run:

`mvn clean install -DskipTests`

Go to job-management service folder and run:

`mvn quarkus:dev`

### Troubleshooting

- Error: `Connection to localhost:5432 refused. Check that the hostname and port are correct and that the postmaster is accepting TCP/IP connections.`

Make sure you have PostgreSQL installed. Find the Build instructions for Fedora [here](https://developer.fedoraproject.org/tech/database/postgresql/about.html).

- Make sure your `pg_hba.conf` file is configured properly. Create a user with username `testuser` and password `testuser` and a database `job-management` in order to avoid errors like `FATAL: password authentication failed for user "testuser"` and `FATAL: database "job-management" does not exist` respectively.