package springfive.cms.domain.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

//import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
//@Document(collecton = "category")

@Data
@Entity
@Table(name ="Category")
@NoArgsConstructor
@AllArgsConstructor
public class Category{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer category_id;

    @Column
    String name;

    @OneToMany(mappedBy = "category")
    List<News> news = new ArrayList<>();

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
  