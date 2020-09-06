package springfive.cms.domain.utilities.Mappers;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springfive.cms.domain.models.Category;
import springfive.cms.domain.models.User;
import springfive.cms.domain.repository.CategoryRepository;
import springfive.cms.domain.repository.UserRepository;
import springfive.cms.vo.UserRequest;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class NewsMapperInternal {


    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    private static final Logger logger = LogManager.getLogger(NewsMapperInternal.class);

    public Category getCategory(String name){
        logger.info("In the news mapper internal");
        Category cat = categoryRepository.findByName(name);

        logger.info(cat.toString());
        return cat;
    }

    public List<User> getAuthors(List<UserRequest> authors){

        List<String> userNames = authors.stream().
                                collect(Collectors.mapping(UserRequest::getName, Collectors.toList()));
        List<User> users = userRepository.findByNameIn(userNames);
        return users;
    }


    public List<UserRequest> toUserRequestList(List<User> users){

        return userMapper.toListUserRequests(users);
    }


}
