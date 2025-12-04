package WGU.Capstone.ChirpCharts.dao;

import WGU.Capstone.ChirpCharts.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface TeamRepository extends JpaRepository<Team, Integer> {
}
