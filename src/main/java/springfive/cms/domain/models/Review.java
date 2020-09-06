package springfive.cms.domain.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Review_table")
public class Review {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "review_id")
    Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    User user;

    @Column
    String status;

    @ManyToOne
    @JoinColumn(name = "News_id", referencedColumnName = "News_id")
    News news;

//
//    @ManyToOne
//    News news;
//

}
