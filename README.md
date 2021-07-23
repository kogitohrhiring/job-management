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

# Integrating keycloak

Setup keycloak server on your system(Keycloak Server should be accessible at http://localhost:8180/auth or http://localhost:8543/auth)
Create a new realms, clients, roles and users as needed
Configure the realms name, client_id and secret from keycloak to appication in appication.properties file
Run the application (Make sure that Keycloak is running before running the application)

### Troubleshooting

-Error:  'org.keycloak.authorization.client.AuthorizationDeniedException: org.keycloak.authorization.client.util.HttpResponseException: Unexpected response from server: 403 / Forbidden / Response from server: {"error":"invalid_clientId","error_description":"Client application [hiring-backend] is not registered as a resource server."'

Make sure that "Authorization Enabled" is set to ON in the clients settings of keycloak server



