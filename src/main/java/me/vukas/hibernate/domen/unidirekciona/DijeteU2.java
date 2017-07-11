package me.vukas.hibernate.domen.unidirekciona;

import javax.persistence.*;

@Entity
@Table(name = "bi_dijete")
public class DijeteU2 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //ako je auto hibernate bira strategiju
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

}
