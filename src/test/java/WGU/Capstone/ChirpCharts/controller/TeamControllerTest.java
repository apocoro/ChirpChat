package WGU.Capstone.ChirpCharts.controller;

import WGU.Capstone.ChirpCharts.dao.TeamRepository;
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
public class TeamControllerTest {

    @Mock
    private TeamRepository teamRepository;

    @InjectMocks
    private TeamController teamController;

    @Test
    public void testGetTeamList() {
        Team team1 = new Team();

        team1.setId(1);
        team1.setFranchiseId(1);
        team1.setTeamName("test");
        team1.setYear(20242025);
        team1.setLogo("test");
        team1.setWins(82);
        team1.setLosses(0);
        team1.setOverTimeLosses(0);
        team1.setLastUpdated(null);

        Team team2 = new Team();
        team2.setId(2);
        team2.setFranchiseId(2);
        team2.setTeamName("test");
        team2.setYear(20242025);
        team2.setLogo("test");
        team2.setWins(82);
        team2.setLosses(0);
        team2.setOverTimeLosses(0);
        team2.setLastUpdated(null);

        given(teamRepository.getTeamList()).willReturn(List.of(team1,team2));
        List<Team> teams = teamController.getTeamList();
        assertThat(teams.size()).isEqualTo(2);
    }
}
