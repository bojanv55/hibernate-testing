package me.vukas.hibernate.domen.bidirekciona;

import javax.persistence.*;

@Entity
@Table(name = "bi_dijete")
public class Dijete {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //ako je auto hibernate bira strategiju
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "otac_relacije")   //default bi bio otac_id; kolona u koju se cuva id oca (FK)
    private Otac otac;

    public void setOtac(Otac otac) {
        this.otac = otac;
    }
}
