package me.vukas.hibernate.domen.unidirekciona;

import javax.persistence.*;

@Entity
@Table(name = "bi_otac")
public class OtacU {    //iz ovog oca ne mozemo da idemo do djece, samo od djece do oca

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //ako je auto hibernate bira strategiju
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    //cesto se koristi radi performansi, jer u suprotnom bi ovdje morali uvijek da ucitavamo svu mogucu djecu

}