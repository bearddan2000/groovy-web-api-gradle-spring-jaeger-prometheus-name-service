package example;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/scientists")
class DefaultRestController {

    private final List<String> scientistsNames;
    private Random random;

    public DefaultRestController() throws IOException {
        InputStream inputStream = new ClassPathResource("/scientists.txt").getInputStream();
        try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            scientistsNames = reader.lines().collect(Collectors.toList());
        }
        catch(IOException e){}
        random = new Random();
    }

    @GetMapping(path = "/random")
    public String name(@RequestHeader HttpHeaders headers) {
        String name = scientistsNames.get(random.nextInt(scientistsNames.size()));
        return name;
    }
}
