package springfive.cms.vo;


import lombok.Data;
import springfive.cms.domain.models.Role;

@Data
public class UserRequest {


    String name;
    String identity;
    Role role;
}
