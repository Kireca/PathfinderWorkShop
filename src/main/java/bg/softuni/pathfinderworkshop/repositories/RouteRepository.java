package bg.softuni.pathfinderworkshop.repositories;

import bg.softuni.pathfinderworkshop.models.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {


}
