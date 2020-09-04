package springfive.cms.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import springfive.cms.domain.models.Category;

import java.util.List;

@Service
public interface CategoryRepository extends JpaRepository<Category, Integer> {

        List<Category> findByName(String name);
        List<Category> findByNameIgnoreCaseStartingWith(String name);
        List<Category> findByNameContaining(String chars);



}
