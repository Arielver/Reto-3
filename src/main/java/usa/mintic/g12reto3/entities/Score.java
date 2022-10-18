package usa.mintic.g12reto3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table (name ="score")
public class Score {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "idReservation")
    private Integer id;
    private Integer score;
    private String messageText;

    @OneToOne
    @JsonIgnoreProperties("score")
    private Reservation reservation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
