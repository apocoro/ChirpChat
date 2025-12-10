
package WGU.Capstone.ChirpCharts.controller;

import WGU.Capstone.ChirpCharts.dao.TeamRepository;
import WGU.Capstone.ChirpCharts.entity.Team;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    // Endpoint for latest team per franchise
    @GetMapping("/team-list")
    public List<Team> getTeamList() {
        return teamRepository.getTeamList();
    }

    @GetMapping("/team-years")
    public List<Team> getTeamYearsList(@RequestParam Long franchiseId) {
        return teamRepository.getTeamYearsList(franchiseId);
    }

}
