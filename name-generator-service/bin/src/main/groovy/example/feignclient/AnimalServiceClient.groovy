package example.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "animal-service-client", url = "\${animal.service.prefix.url}")
public interface AnimalServiceClient {

    @GetMapping("/api/v1/animals/random")
    String randomAnimalName();

}
