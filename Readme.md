# Coindesk test


## Part 1

### query the database directly:

Pros: Faster because you don't have more layers in the middle and it's pretty simple to implement. And simpler because you only have to create the query so the learning curve is shorter.\
Cons: Potential security risks because of credentials management. Lack of abstraction because in case you need to change the database to a different language, the client should change the logic as well.

### query via REST API:

Pros: More abstraction give you the possibility to decouple the query from the client and you additional security measures.\
Cons: Slightly slower, dependency on API availability.

### Which one I'd choose:
Query via rest api. Creating a rest api today is pretty simple in almost any language and it can be done pretty fast, without compromising simplicity. And it also gives you a bunch of benefits like security, scalability, maintainability. And the most important thing is the client won't care on the query but on the results.

### What should change for choose the other method?
If speed is crucial and the database structure is unlikely to change often, querying directly might be more efficient.


## Part 2

Dockerizing give you isolation because you are encapsulating dependencies, This ensures that the test runs consistently across different environments.
Docker enables parallel execution of tests in separate containers, speeding up test suites and reducing overall execution time. 
Dockerization introduces some overhead in terms of image creation and container orchestration, impacting initial setup time.
Complex network configurations may be needed for tests involving multiple containers, adding complexity to setups.

## Part 3
``
mvn compile
``

``
mvn exec:java -Dexec.mainClass=org.example.CryptoComIngest
``
