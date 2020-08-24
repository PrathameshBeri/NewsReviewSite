package springfive.cms.domain.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

//import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
//@Document(collecton = "category")

@Data
@Entity
@Table(name ="Category")
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    String id;



    String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setName(String name){
        this.name = name;
    }


}
  