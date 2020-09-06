package springfive.cms.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springfive.cms.domain.models.News;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {


    List<News> findNewsByCategoryName(String name);

    News findByTitle(String title);
}
