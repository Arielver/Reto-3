package usa.mintic.g12reto3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Integer idReservation;
    private Date starDate;
    private Date devolutionDate;
    private String status="created";

    @ManyToOne
    @JoinColumn(name="audienceId")
    @JsonIgnoreProperties({"reservations","messageS"})
    private Audience audience;

    @ManyToOne
    @JoinColumn(name="clientId")
    @JsonIgnoreProperties({"reservations","messageS"})
    private Client client;

    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "reservation")
    @JsonIgnoreProperties("reservation")
    private Score score;

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStarDate() {
        return starDate;
    }

    public void setStarDate(Date starDate) {
        this.starDate = starDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Audience getAudience() {
        return audience;
    }

    public void setAudience(Audience audience) {
        this.audience = audience;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
