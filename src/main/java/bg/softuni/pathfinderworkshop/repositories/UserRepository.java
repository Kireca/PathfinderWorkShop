package bg.softuni.pathfinderworkshop.repositories;

import bg.softuni.pathfinderworkshop.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
