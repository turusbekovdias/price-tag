## Starter Project

Use this project as a basis for other microservices. It has approved project structure (folders, conventions etc.) and example code.

### Requirements
* All code should be covered with tests
* Application properties should be stored in ConfigServer
* All Spring bean depencies should be autowired via constructor autowiring. To do so, use Lombok annotation `@RequiredArgsConstructor`
and mark fields as `private final`.
* For logging use `@Slj4` lombok annotation


### TODO
* register with Eurika
* add micrometer, grafana & prometheus monitoring
* add sleuth log tracing
* ~~create Dockerfile with env vars~~
