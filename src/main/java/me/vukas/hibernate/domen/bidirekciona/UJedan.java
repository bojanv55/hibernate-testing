package me.vukas.hibernate.domen.bidirekciona;

import javax.persistence.*;

@Entity
@Table(name = "ujedan")
public class UJedan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    //ovaj cascade nam omogucava da zapamtimo i JEdan klasu u bazu istovremeno samo sa pamcenjem
    //ove klase UJedan (ali mora prethodno Jedan biti dodjeljen ovom fieldu).
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rel_jedan") //nije neophodno = ima default vrijednosti
    private Jedan jedanOtac;

    public void setJedanOtac(Jedan jedanOtac) {
        this.jedanOtac = jedanOtac;
    }
}
