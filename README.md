# Overview

This repo contains three spring boot projects:
- registry, Eureka Service Registry
- customer, Customer microservice, used for Auth and user related requests.
- account, Account microservice

**Note: Not all APIs are complete, and Data is stubbed.**
Idea here to mostly demonstrate the understanding of following concepts:
- Eureka based service discovery
- Load balancing using ribbon client
- Role based authorization

# Building & Running
- `cd` into respective directory and Use command `mvn spring-boot:run` to start the services
- start all services including `registry`
- for running multiple instances of a service use `mvn spring-boot:run -Dspring-boot.run.arguments=--server.port={PORT}`

## Note: There are only two users in the system 
1. username: god, password: god (Branch Manager)
2. username: dog, password: dog (Customer)

# Sample Requests
- Login using username, password
```
curl -v  -H "Content-Type: application/json" http://customer-service/api/public/login -d'{"username": "god", "password": "god"}'
```
Note down the authorization header value.

- Fetch current user details
```
curl -v -H "Authorization: Bearer {ACCESS_TOKEN}" -H "Content-Type: application/json" http://customer-service/api/users/me
```

- List users (Requires Branch Manager access)
```
curl -v -H "Authorization: Bearer {ACCESS_TOKEN}" -H "Content-Type: application/json" http://customer-service/api/users
```

- List Accounts (Requires Branch Manager access)
```
curl -v -H "Authorization: Bearer {ACCESS_TOKEN}" -H "Content-Type: application/json" http://account-service/api/accounts/
```

- Fetch my account
```
curl -v -H "Authorization: Bearer {ACCESS_TOKEN}" -H "Content-Type: application/json" http://account-service/api/accounts/my
```
