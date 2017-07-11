package me.vukas.hibernate.domen.bidirekciona;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "otac_vise")
public class OtacVise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //ako je auto hibernate bira strategiju
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    //join table je opciona i moze biti po defaultu
    @JoinTable(name = "otac_dijete_vise", joinColumns = {
            @JoinColumn(name = "otac_id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "dijete_id")
    })
    List<DijeteVise> djeca = new ArrayList<>();

    public void dodajDjete(DijeteVise dijete){
        if(!this.djeca.contains(dijete)) {  //vjerov postoji bolji nacin da se osigura da ne dodje do infinite-loopa
            this.djeca.add(dijete);
            dijete.dodajOca(this);
        }
    }
}
