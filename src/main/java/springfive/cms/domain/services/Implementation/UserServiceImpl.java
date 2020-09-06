package springfive.cms.domain.services.Implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springfive.cms.domain.models.User;
import springfive.cms.domain.repository.UserRepository;
import springfive.cms.domain.services.services.UserService;
import springfive.cms.domain.utilities.Mappers.UserMapper;
import springfive.cms.vo.UserRequest;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public UserRequest getOne(int id) {

        User user = userRepository.findById(id).get();

        return userMapper.toUserRequest(user);
    }

    @Override
    public List<UserRequest> getAll() {

        List<User> userList = userRepository.findAll();
        return userMapper.toListUserRequests(userList);
    }

    @Override
    public UserRequest addUser(UserRequest usr) {
        logger.info("In user service impl and the usrequest is " + usr.toString());
        User user = userMapper.toUser(usr);
        User user1 = userRepository.save(user);
        return userMapper.toUserRequest(user1);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);

    }
}
