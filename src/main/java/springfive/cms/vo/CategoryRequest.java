package springfive.cms.vo;


import lombok.Data;

/**
 * @author Prathamesh
 */

@Data
public class CategoryRequest {
    String name;

    public String getName() {
        return name;
    }

   public void setName(String name) {
        this.name = name;
    }




}
