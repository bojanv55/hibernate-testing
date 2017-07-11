package me.vukas.hibernate.domen;

import javax.persistence.*;

//entitet sa sekvencom (ako baza podrzava sekvence)
@Entity
//po defaultu naziv tabele za ovo je entit_sa_sekv
public class EntitSaSekv {

    @Id
    //u bazi se mora generisati sekvenca "create sequence sekv1;"
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sekv1seq")
    @SequenceGenerator(name = "sekv1seq" ,sequenceName = "sekv1")
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    private String seq;

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }
}
