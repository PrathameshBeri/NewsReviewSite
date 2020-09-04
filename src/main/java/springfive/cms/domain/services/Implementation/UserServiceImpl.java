package springfive.cms.domain.services.Implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springfive.cms.domain.models.User;
import springfive.cms.domain.repository.UserRepository;
import springfive.cms.domain.services.services.UserService;
import springfive.cms.vo.UserRequest;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public User getOne(int id) {

        User user = userRepository.findById(id).get();

        return user;
    }

    @Override
    public List<User> getAll() {

        List<User> userList = userRepository.findAll();
        return userList;
    }

    @Override
    public User addUser(UserRequest usr) {
        logger.info("In user service impl and the usrequest is " + usr.toString());
        User user = new User();
        user.setName(usr.getName());
        user.setIdentity(usr.getIdentity());
        user.setRole(usr.getRole());

        User user1 = userRepository.save(user);
        return user1;
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);

    }
}
