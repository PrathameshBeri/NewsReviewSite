package springfive.cms.domain.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "News_id")
    Integer id;

    @Column
    String title;

    @Column
    String content;

    @ManyToMany(mappedBy = "articles", cascade = CascadeType.ALL)
    @JsonIgnore
    List<User> authors = new ArrayList<>();


//    @ManyToMany
//    @JoinTable(name = "News_Reviewers",
//                joinColumns = @JoinColumn(name = "News_id", referencedColumnName = "id"),
//                inverseJoinColumns = @JoinColumn(name="Reviewer_id", referencedColumnName = "id"))
//    Set<User> mandatoryReviewers = new HashSet<>();



        @OneToMany(mappedBy = "news")
        Set<Review> reviews;

         @ManyToOne
         @JoinColumn(name = "Category_id", referencedColumnName = "id")
          Category category;
//
//    @OneToMany
//    Set<Tag> tags;

    public Review review(String userId, String status){
       return null;
    }

    public Boolean revised(){
            return null;
//        return this.mandatoryReviewers.stream()
//                                    .allMatch(reviewer -> this.reviewers.stream()
//                                            .anyMatch(review ->reviewer.id.equals(review.userId) &&
//                                                                 "approved".equals(review.status)));
    }
 
}
