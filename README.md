# mTab Random Number Generator

This project provides a partial implementation of a random number generator, exposed via a REST API.

The numbers generated must be cryptographically secure (impossible to predict ahead of time).

The entrypoint is `com.mtab.spring.boot.Application` and the server is configured to listen on post 8080.

## Tasks
1. The service is incomplete and will not start. Examine the code and complete the implementation, ensuring the design goal of security is met.
2. Enhance the functionality provided by the service to allow for numbers to be generated within a provided range. It should still be possible to generate a number without a range.
3. Update the tests to verify that the new functionality works correctly. Include positive and negative scenarios.
4. Add a stub implementation of `RandomService`. There should be a configuration setting to control which service is active when the service starts.

## Notes
- You may use any and all coding assistants during this exercise, but you must be able to explain any code that is written
- You may add new libraries, but be prepared to justify any additions
- Do not reinvent the wheel. Use language and/or framework features where it makes sense
- Write the code as you would for a real customer-facing project
  - Clear structure and easy to read/maintain
  - Validate arguments and demonstrate thoughtful exception handling
  - Security, reliability, and performance are paramount