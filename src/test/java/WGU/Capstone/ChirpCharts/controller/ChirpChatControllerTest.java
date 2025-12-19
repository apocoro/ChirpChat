package WGU.Capstone.ChirpCharts.controller;

import WGU.Capstone.ChirpCharts.dao.ChirpChatRepository;
import WGU.Capstone.ChirpCharts.entity.ChirpChat;
import WGU.Capstone.ChirpCharts.entity.Team;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class ChirpChatControllerTest {
    @Mock
    private ChirpChatRepository chirpChatRepository;

    @InjectMocks
    private ChirpChatController chirpChatController;

    @Test
    public void testGetChatLogs() {
        ChirpChat chat1 = new ChirpChat();
        chat1.setId(1);
        chat1.setFranchiseId(1);
        chat1.setYear(20242025);
        chat1.setMessage("test");

        ChirpChat chat2 = new ChirpChat();
        chat2.setId(2);
        chat2.setFranchiseId(1);
        chat2.setYear(20242025);
        chat2.setMessage("test");

        given(chirpChatRepository.getChatsByTeamAndYear(1, 20242025)).willReturn(List.of(chat1,chat2));
        List<ChirpChat> chats = chirpChatController.getChatLogs(1, 20242025);
        assertThat(chats.size()).isEqualTo(2);
    }


}
