package WGU.Capstone.ChirpCharts.dao;

import WGU.Capstone.ChirpCharts.entity.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200")
public interface TeamRepository extends JpaRepository<Team, Integer> {

    //Page<Team> findByFranchiseId(@Param("franchiseId") Long id, Pageable pageable);


    @Query("SELECT t FROM Team t WHERE t.year IN (" +
            "SELECT MAX(t2.year) FROM Team t2 GROUP BY t2.franchiseId" +
            ")")
    List<Team> getTeamList();

    @Query("SELECT t FROM Team t WHERE t.franchiseId = :franchiseId")
    List<Team> getTeamYearsList(@Param("franchiseId") Long franchiseId);
}
