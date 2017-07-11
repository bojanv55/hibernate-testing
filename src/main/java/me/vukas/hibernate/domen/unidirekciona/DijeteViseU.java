package me.vukas.hibernate.domen.unidirekciona;

import javax.persistence.*;

@Entity
@Table(name = "dijete_vise")
public class DijeteViseU {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //ako je auto hibernate bira strategiju
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;


    public Long getId() {
        return id;
    }
}
