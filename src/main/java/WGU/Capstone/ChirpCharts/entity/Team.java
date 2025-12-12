package WGU.Capstone.ChirpCharts.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "team")
@Data

public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "franchise_id")
    private int franchiseId;
    @Column(name = "team_name")
    private String teamName;
    @Column(name = "year")
    private Integer year;
    @Column(name = "logo")
    private String logo;
    @Column(name = "wins")
    private Integer wins;
    @Column(name = "losses")
    private Integer losses;
    @Column(name = "over_time_losses")
    private Integer overTimeLosses;
    @Column(name = "last_updated")
    private Date lastUpdated;
}
