package me.vukas.hibernate.domen.unidirekciona;

import me.vukas.hibernate.domen.bidirekciona.Jedan;

import javax.persistence.*;

@Entity
@Table(name = "ujedan")
public class UJedanUni {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rel_jedan") //nije neophodno = ima default vrijednosti
    private JedanUni jedanOtac;

    public void setJedanOtac(JedanUni jedanOtac) {
        this.jedanOtac = jedanOtac;
    }
}
