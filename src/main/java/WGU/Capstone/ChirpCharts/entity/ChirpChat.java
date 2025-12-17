package WGU.Capstone.ChirpCharts.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "chirp_chat")
@Data
public class ChirpChat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "franchise_id")
    private Long franchiseId;
    @Column(name = "year")
    private String year;
    @Column(name = "message")
    private String message;
}
