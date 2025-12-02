package WGU.Capstone.ChirpCharts.dao;

import WGU.Capstone.ChirpCharts.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}
