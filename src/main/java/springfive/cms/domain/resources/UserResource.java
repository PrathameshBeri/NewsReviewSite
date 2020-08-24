package springfive.cms.domain.resources;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfive.cms.domain.models.User;
import springfive.cms.vo.UserRequest;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserResource {


    @GetMapping(value ="/{id}")
    public ResponseEntity<User> findOne(@PathVariable("id") String id){

        return ResponseEntity.status(HttpStatus.OK).body(new User());
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){

        return ResponseEntity.ok(Arrays.asList(new User(), new User()));

    }

    @PostMapping
    public ResponseEntity<User> createUser(UserRequest ur){

        return ResponseEntity.status(HttpStatus.CREATED).body(new User());
    }

    @DeleteMapping(value ="/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeUser(@PathVariable("id") String id){


    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String id, UserRequest user)
    {

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new User());

    }
}
