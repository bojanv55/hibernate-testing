package me.vukas.hibernate.domen;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;

//CREATE VIEW pogled
//        AS
//        SELECT p.ID AS I, p.ENUMID*10 as K FROM PROBNI p

@Entity
@Immutable  //mozemo samo da radimo SELECT, ali ne i UPDATE
@Table(name = "pogled")
public class Pogled {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "I", updatable = false, nullable = false)
    private int ajdi;

    @Column(name = "K")
    private int broj;

    public int getBroj() {
        return broj;
    }
}
