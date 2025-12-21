package WGU.Capstone.ChirpCharts.entity;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeamTest {


    @Test
    void testGetterSettersTeam() {

        Team team = new Team();


        team.setFranchiseId(1);
        team.setTeamName("test");
        team.setYear(20242025);
        team.setLogo("test");
        team.setWins(82);
        team.setLosses(0);
        team.setOverTimeLosses(5);
        team.setLastUpdated(null);

        assertEquals(1, team.getFranchiseId());
        assertEquals("test", team.getTeamName());
        assertEquals(20242025, team.getYear());
        assertEquals("test", team.getLogo());
        assertEquals(82, team.getWins());
        assertEquals(0, team.getLosses());
        assertEquals(5, team.getOverTimeLosses());
        assertEquals(null, team.getLastUpdated());
    }
}
