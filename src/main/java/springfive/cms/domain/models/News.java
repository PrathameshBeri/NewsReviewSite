package springfive.cms.domain.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
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

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JsonManagedReference
    @JoinTable(
            name = "News_Authors",
            joinColumns = @JoinColumn(name = "News_id", referencedColumnName = "News_id"),
            inverseJoinColumns = @JoinColumn(name = "User_id", referencedColumnName = "User_id")
    )
    Set<User> authors = new HashSet<>();


//    @ManyToMany
//    @JoinTable(name = "News_Reviewers",
//                joinColumns = @JoinColumn(name = "News_id", referencedColumnName = "id"),
//                inverseJoinColumns = @JoinColumn(name="Reviewer_id", referencedColumnName = "id"))
//    Set<User> mandatoryReviewers = new HashSet<>();



        @OneToMany(mappedBy = "news")
        @JsonIgnore
        Set<Review> reviews;

         @ManyToOne
         @JoinColumn(name = "Category_id", referencedColumnName = "id")
         @JsonIgnore
         Category category;
//
//    @OneToMany
//    Set<Tag> tags;

   /* public Review review(String userId, String status){
       return null;
    } */

    public Boolean revised(){
            return null;
//        return this.mandatoryReviewers.stream()
//                                    .allMatch(reviewer -> this.reviewers.stream()
//                                            .anyMatch(review ->reviewer.id.equals(review.userId) &&
//                                                                 "approved".equals(review.status)));
    }


    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
