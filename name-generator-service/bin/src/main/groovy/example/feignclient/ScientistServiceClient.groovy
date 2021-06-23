package example.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "scientist-service-client", url = "\${scientist.service.prefix.url}")
public interface ScientistServiceClient {
    @GetMapping("/api/v1/scientists/random")
    String randomScientistName();
}
