package springfive.cms.domain.resources;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value ="/hello")
    public  String getHome(@RequestParam(name = "name", defaultValue ="World") String name)
    {

        return String.format("Hello, %s",  name);
    }


    @GetMapping(value = "/trash")
    public String getTrash(){

        return "This is a trash api";
    }
}
