package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static strman.Strman.toKebabCase;

@RestController
@RequestMapping("/api/v1/names")
class DefaultRestController {

    @Autowired
    private example.feignclient.AnimalServiceClient animalServiceClient;

    @Autowired
    private example.feignclient.ScientistServiceClient scientistServiceClient;


    @GetMapping(path = "/random")
    public String name() throws Exception {
        String animal = animalServiceClient.randomAnimalName();
        String scientist = scientistServiceClient.randomScientistName();
        String name = toKebabCase(scientist) + "-" + toKebabCase(animal);
        return name;
    }


}
