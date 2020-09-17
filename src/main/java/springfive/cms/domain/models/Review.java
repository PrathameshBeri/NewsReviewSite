package springfive.cms.domain.models;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Review_table")
public class Review {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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


    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", user=" + user.getName() +
                ", status='" + status + '\'' +
                ", news=" + news.getTitle() +
                '}';
    }
}
