# groovy-web-api-gradle-spring-jaeger-prometheus-name-service

## Description
Calls remote services and
benchmarks the response. Uses prometheus
to graph response times.

### STEP 1
Once the project is done building, make
some api calls `http://localhost:82/api/v1/names/random`.

To see a graph of response times:
- Nav to http://localhost
- Classic UI
  - Click Graph tab
    - Search: 'scrape_series_added'
      or 'scrape_duration_second'
      or 'http_request_duration_ms_bucket'
    - Duration 1m

For health check:
- Nav to http://localhost
- Targetes

To see a coverage of response times:
- Nav to http://localhost:81
- Look on left-hand side find services.

## Tech stack
- groovy
- gradle
  - opentracing

## Docker stack
- gradle:jdk11
- jaegertracing/all-in-one:1.17
- prom/prometheus

## To run
`sudo ./install.sh -u`
- PROMETHEUS DASHBOARD http://localhost
- JAEGER DASHBOARD http://localhost:81
- API http://localhost:82/api/v1/names/random

## To stop
`sudo ./install.sh -d`

## For help
`sudo ./install.sh -h`

## Credits
- [Project concept](https://github.com/himankbatra/opentracing-microservices-example)
