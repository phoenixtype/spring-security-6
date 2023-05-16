## SPRINGBOOT 3 + SPRING SECURITY 6 - JWT Authentication and Authorization

1. When a Http request is sent the first thing that is executed within the application is the filter (JwtAuthFilter)

2. There will be an internal check in the JwtAuthFilter to confirm if the user has a jwt token or not

3. Tf the token is missing then a 403 (missing jwt) message to the client

4. If a jwt token exists, the filter using the UserDetailsService will try to fetch user details from the database, this is done with the user subject (primary credential) extracted from the claim (payload) of the jwt token

5. The database then sends the user details if it exists and if it does not exist a 403 (user does not exist) message is sent to the client

6. Meanwhile, If everything is okay we start the validate JWT process (validate the token based on the user)

7. In doing this a call is made to the JwtService with the user object and the token string.

8. If the token is expired, or it's not for that user then a 403 (invalid JWT token) message is sent to the client

9. Otherwise, if it is the correct token we call and update the SecurityContextHolder to set the connected user (user authenticated/updated the authentication manager)

10. This will automatically dispatch the request to the DispatcherServlet and then forwarded to the controller
