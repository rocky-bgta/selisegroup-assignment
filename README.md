## Pre-requisite for the course
- Java 8 or above
- MySQL DB 
- Maven 
- Assume 8080 port not occupied by some other application
- Set MySQL DB username and password to application.yml file
## Maven Commands used in the course

|     Maven Command       |     Description          |
| ------------- | ------------- |
| "mvn clean install" | To generate a jar inside target folder |
| "mvn spring-boot:run" | To start a springboot maven project |


- If this project run successfully it create selise DB automically
- This application exposed two end point

* http://localhost:8080/api/accounts/{{ACC1001}}
* http://localhost:8080/api/accounts/get-all 


To call get-all user endpoint 
    first we need a access token that have admin privilege 
Execute the following curl:

```bash
curl --location 'http://localhost:8080/get-access-token' \
--header 'Content-Type: application/json' \
--data '{
  "username": "salahin",
  "password": "salahin"
}'


you will get jwt token and use that token to call following endpoint

curl --location 'http://localhost:8080/api/accounts/get-all' \
--header 'Authorization: Bearer <your-admin-token>'

with this admin privilege token we access both end point that following as well

curl --location 'http://localhost:8080/api/accounts/ACC1001' \
--header 'Authorization: Bearer <your-admin-token>'


In DB there is another user tahim by executing the following curl
curl --location 'http://localhost:8080/get-access-token' \
--header 'Content-Type: application/json' \
--data '{
"username": "tahim",
"password": "tahim"
}'

we will get jwt token, and with this token we only execute
curl --location 'http://localhost:8080/api/accounts/ACC1001' \
--header 'Authorization: Bearer <your-user-token>'

but can not 'execute http://localhost:8080/api/accounts/get-all'

Both endpoint are protected only accessible by access token.
