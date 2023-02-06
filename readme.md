# OpenTelemetry Quarkus example

The project consists of two microservices: `is-odd` and `is-even`. They return `true` or `false` for a given number depending if the number is odd or is even. They can be called like this:

 - http://localhost:8081/is-even/42
 - http://localhost:8080/is-odd/42


## Start the microservices

You need to start the microservices individually, but they can both be executed in parallel on your local machine.

```
cd is-odd
./mvnw clean quarkus:dev
```

```
cd is-even
./mvnw clean quarkus:dev
```

`is-odd` is already built with support for OpenTelemetry to collect tracing data. In order to store and view the data, you need to start a backend like jaeger:

```sh
docker run -d --name jaeger \
  -e COLLECTOR_OTLP_ENABLED=true \
  -p 16686:16686 \
  -p 4317:4317 \
  -p 4318:4318 \
  jaegertracing/all-in-one
```

To view the jager-ui point your browser to http://localhost:16686/ .

Please keep in mind, that `is-even` doesn't publish any tracing data yet.


## Your task: Add OpenTelemetry to is-even

Your task is to add OpenTelemetry to the `is-even` microservice.

1. Read the [Quarkus OpenTelemetry](https://quarkus.io/guides/opentelemetry) guide
2. Add the OpenTelemetry dependency to quarkus
3. Configure the OpenTelemetry extension
4. Add the TraceId to the log format

