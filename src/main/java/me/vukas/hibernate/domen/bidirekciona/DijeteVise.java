package me.vukas.hibernate.domen.bidirekciona;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dijete_vise")
public class DijeteVise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //ako je auto hibernate bira strategiju
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @ManyToMany(mappedBy = "djeca") //naziv polja u OtacViseU klasi
    List<OtacVise> ocevi = new ArrayList<>();

    public void dodajOca(OtacVise otac){
        if(!this.ocevi.contains(otac)) {
            this.ocevi.add(otac);
            otac.dodajDjete(this);
        }
    }
}
