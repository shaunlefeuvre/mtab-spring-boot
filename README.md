# mTab Spring Boot

This project provides a minimal Spring Boot configuration using the latest release. 

The entrypoint is `com.mtab.spring.boot.Application` and the server will be start on port 8080.

## Tasks
1. Create an API that accepts a string of text in the request body and returns a UUID for the request
2. This API should persist the text using any method, it does not need to be durable
3. Create a second API that accepts one UUID and returns useful information about the text (example: number of words)
4. Create tests that ensure the correctness of your implementation

## Notes
- You may add any third party libraries but be prepared to justify your choice
- Use and prefer modern Java language features where appropriate
- Use and prefer Spring Framework features where appropriate