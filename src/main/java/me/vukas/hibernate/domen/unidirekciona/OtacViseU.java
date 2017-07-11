package me.vukas.hibernate.domen.unidirekciona;

import me.vukas.hibernate.domen.bidirekciona.DijeteVise;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "otac_vise")
public class OtacViseU {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //ako je auto hibernate bira strategiju
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    //EAGER == N+1 PROBLEM!!
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) //sa fetch uvijeh dohvati svu djecu kada citamo
    //join table je opciona i moze biti po defaultu; bila bi OtacViseU_DijeteViseU; djeca_id; ??
    @JoinTable(name = "otac_dijete_vise", joinColumns = {
            @JoinColumn(name = "otac_id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "dijete_id")
    })
    @OrderBy("id DESC, id ASC") //uvijek sortira djecu po nekoj koloni - skupa operacija jer uvijek radi ORDER BY
    List<DijeteViseU> djeca = new ArrayList<>();

    public void dodajDjete(DijeteViseU dijete){
        this.djeca.add(dijete);
    }

    public List<DijeteViseU> getDjeca() {
        return djeca;
    }
}
