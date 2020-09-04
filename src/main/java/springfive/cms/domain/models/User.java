package springfive.cms.domain.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "user_table")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "User_id")
    Integer id;

    @Column
    String identity;

    @Column
    String name;

    @Column
    Role role;


    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    @JsonIgnore
    List<Review> reviews = new ArrayList<>();


    @ManyToMany
    @JoinTable(
            name = "News_Authors",
            joinColumns = @JoinColumn(name = "User_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "News_id", referencedColumnName = "id")
    )
    List<News> articles = new ArrayList<>();

}
