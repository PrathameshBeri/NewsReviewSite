package springfive.cms.domain.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
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
    @JsonBackReference
    Set<Review> reviews = new HashSet<>();

    @ManyToMany(mappedBy = "authors", cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    @JsonIgnore
    Set<News> articles = new HashSet<>();


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", identity='" + identity + '\'' +
                ", name='" + name + '\'' +
                ", role=" + role +
                '}';
    }
}
