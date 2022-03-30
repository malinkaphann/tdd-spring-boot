# TDD Oriented Api Design

This is one of the best to implement an API.

## TopDown Approach

This is one kind of TDD in which an integration test will be written first.  

## Integration Test


```
gradle test --tests IntegrationTest
```

## Controller Test

```
gradle test --tests LocationControllerTest
```


## Service Test

```
gradle test --tests LocationServiceTest
```

## Repository Test

```
gradle test --tests LocationRepositoryTest
```

## Reference
Thank to the great video presentation of Sannidhi Jalukar and Madhura Bhave.<br/>
[Test Driven Development with Spring Boot - Sannidhi Jalukar, Madhura Bhave](https://tanzu.vmware.com/content/springone-platform-2017/test-driven-development-with-spring-boot-sannidhi-jalukar-madhura-bhave)
