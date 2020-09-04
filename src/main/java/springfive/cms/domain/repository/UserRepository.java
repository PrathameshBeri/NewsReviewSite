package springfive.cms.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import springfive.cms.domain.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
