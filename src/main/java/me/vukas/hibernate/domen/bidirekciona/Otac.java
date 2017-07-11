package me.vukas.hibernate.domen.bidirekciona;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bi_otac")
public class Otac { //iz ovog oca mozemo da idemo do djece i od djece do oca nazad

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //ako je auto hibernate bira strategiju
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    //stavljamo cascade=ALL da ne bi morali da pamtimo Oca, pa dijete. Ovako automatski pamtimo svu djecu za oca
    @OneToMany(mappedBy = "otac", cascade = CascadeType.ALL, orphanRemoval = true)   //naziv atributa u djetetu koje drzi key
    private List<Dijete> djeca = new ArrayList<>();

    public void dodajDijete(Dijete dijete){
        this.djeca.add(dijete);
        dijete.setOtac(this);   //MORAMO UPDATEOVATI RELACIJU NA OBJE STRANE KADA DODAJEMO ILI BRISEMO
    }

}
