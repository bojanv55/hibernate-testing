package me.vukas.hibernate.domen.bidirekciona;

import javax.persistence.*;

@Entity
@Table(name = "jedan")
public class Jedan {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    //kad je odje cascade, I koristimo jedanrepo za pamcenje, zapamticemo i ujedan klasu istovremeno
    //kada pamtimo ovu klasu (jedan)
    @OneToOne(mappedBy = "jedanOtac", cascade = CascadeType.ALL)   //naziv polja iz klase UJedan
    private UJedan ujedan;

    public void setUjedan(UJedan ujedan) {
        this.ujedan = ujedan;
        ujedan.setJedanOtac(this);
    }
}
