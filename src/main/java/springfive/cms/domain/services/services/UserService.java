package springfive.cms.domain.services.services;


import org.springframework.stereotype.Service;
import springfive.cms.domain.models.User;
import springfive.cms.vo.UserRequest;

import java.util.List;


public interface UserService {

    public User getOne(int id);

    public List<User> getAll();

    public User addUser(UserRequest usr);

    public void deleteUser(int id);
}
