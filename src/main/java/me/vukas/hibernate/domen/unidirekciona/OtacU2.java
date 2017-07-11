package me.vukas.hibernate.domen.unidirekciona;

import me.vukas.hibernate.domen.bidirekciona.Dijete;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bi_otac")
public class OtacU2 {    //iz ovog oca idemo do djece, ali ne i iz djece do oca. Nije toliko popularno zbog perform.

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //ako je auto hibernate bira strategiju
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "otac_relacije") //podesavamo kolonu u djetetu za FK
    private List<DijeteU2> djeca = new ArrayList<>();

    public void dodajDijete(DijeteU2 dijete){
        this.djeca.add(dijete);
    }

}