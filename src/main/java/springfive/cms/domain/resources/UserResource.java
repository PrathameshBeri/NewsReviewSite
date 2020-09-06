package springfive.cms.domain.resources;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfive.cms.domain.models.User;
import springfive.cms.domain.services.services.UserService;
import springfive.cms.vo.UserRequest;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserResource {

    private static final Logger logger = LogManager.getLogger(UserResource.class);

    @Autowired
    UserService userService;

    @GetMapping(value ="/{id}")
    public ResponseEntity<UserRequest> findOne(@PathVariable("id") Integer id){
        logger.info("In UserService class");
        UserRequest user = userService.getOne(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping
    public ResponseEntity<List<UserRequest>> findAll(){

        List<UserRequest> userList = userService.getAll();
        return ResponseEntity.ok(userList);

    }

    @PostMapping
    public ResponseEntity<UserRequest> createUser(@RequestBody UserRequest ur){
        logger.info(ur.toString());
        logger.info(userService.toString());
        UserRequest user = userService.addUser(ur);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @DeleteMapping(value ="/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeUser(@PathVariable("id") Integer id){

        userService.deleteUser(id);

    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String id, UserRequest user)
    {

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new User());

    }
}
