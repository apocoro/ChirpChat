package WGU.Capstone.ChirpCharts.dao;

import WGU.Capstone.ChirpCharts.entity.ChirpChat;
import WGU.Capstone.ChirpCharts.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

public interface ChirpChatRepository extends JpaRepository<ChirpChat, Integer> {

    @Query("SELECT c FROM ChirpChat c WHERE c.franchiseId = :franchiseId AND c.year = :year")
    List<ChirpChat> getChatsByTeamAndYear(@Param("franchiseId") Integer franchiseId, @Param("year") Integer year);

}
