

package springfive.cms.vo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springfive.cms.domain.models.Role;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    Integer id;
    String name;
    String identity;
    Role role;

}
