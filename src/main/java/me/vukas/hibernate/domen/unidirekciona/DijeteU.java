package me.vukas.hibernate.domen.unidirekciona;

import me.vukas.hibernate.domen.bidirekciona.Otac;

import javax.persistence.*;

@Entity
@Table(name = "bi_dijete")
public class DijeteU {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //ako je auto hibernate bira strategiju
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "otac_relacije")   //default bi bio otac_id; kolona u koju se cuva id oca (FK)
    private OtacU otacU;

    public void setOtac(OtacU otacU) {
        this.otacU = otacU;
    }
}
