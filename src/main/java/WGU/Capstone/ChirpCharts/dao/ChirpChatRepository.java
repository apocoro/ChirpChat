package WGU.Capstone.ChirpCharts.dao;

import WGU.Capstone.ChirpCharts.entity.ChirpChat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChirpChatRepository extends JpaRepository<ChirpChat, Long> {
}
