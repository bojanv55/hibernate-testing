package me.vukas.hibernate.domen;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "probni", schema = "public")
public class Probniz {

    @Id //podrzava primitive/wrappere i String, Date, BigDecimal, BigInteger
    //IDENTITY = auto increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)   //updatable i nullable radi interne hibernate oprimizacije
    private int ajdi;

    //@Column(name = "ime") //nepotrebno jer je isto ime
    private String ime;

    @Transient  //govori hibernateu da ne mapira ovo u kolonu
    private Long nemojMapirati;

    //TIMESTAMP - default; DATE - samo datum; TIME - samo vrijeme
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;

    //ORDINAL je default za enumeracije bez anotacije - koristi ordinal enuma; STRING - koristi string naziv
    //@Enumerated(EnumType.ORDINAL)
    //@Convert(converter = EnumConverter.class) //ako nije autoApply na anotaciji konvertera moramo ovo da koristimo
    //ovdje koristimo EnumConverter.class jer smo na njoj rekli autoApply=true
    @Column(name = "enumid")
    private Enumeracija enumeracija;

    //izvrsavamo dodatni upit da dohvatimo polje koje je upisano na trigger u bazi
    @Generated(GenerationTime.ALWAYS)   //never; insert; always ==insert and update
    @Column(name = "generisana")
    private Date generated;

    //ako ne treba uvijek da se izvrsava, moze se napraviti part of a custom query
    @Generated(GenerationTime.ALWAYS)   //uvijek izvrsi upit dodatno, ovaj put sa funkcijom ispod
    @Formula("SUBSTRING(ime,1,1)")   //nije portabilno. uzima prvi karakter iz kolone "ime"
    private String prvoSlovoImena;

    @Column(name = "autogen")
    private Date automatskaInicijalizacija;

    @PrePersist //poziva se prije cuvanja kako bi se inicijalizovalo svojstvo
    private void prijeCuvanja(){
        this.automatskaInicijalizacija = new Date();
    }

    @PreRemove
    private void prijeBrisanja(){

    }

    public int getAjdi() {
        return ajdi;
    }

    public void setAjdi(int ajdi) {
        this.ajdi = ajdi;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Long getNemojMapirati() {
        return nemojMapirati;
    }

    public void setNemojMapirati(Long nemojMapirati) {
        this.nemojMapirati = nemojMapirati;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Enumeracija getEnumeracija() {
        return enumeracija;
    }

    public void setEnumeracija(Enumeracija enumeracija) {
        this.enumeracija = enumeracija;
    }

    public Date getGenerated() {
        return generated;
    }

    public String getPrvoSlovoImena() {
        return prvoSlovoImena;
    }

    public String getPrvoSlovoImenaOpetKalk(){
        //problem -> svaki put kada se zove metod, izvrsava se skupa kalkulacija
        return ime.substring(0,1);
    }

    @Transient
    private String prvoSlovoSamoJednom;

    public String getPrvoSlovoSamoJednom(){
        if(this.prvoSlovoSamoJednom == null)
            this.prvoSlovoSamoJednom = getPrvoSlovoImenaOpetKalk(); //samo 1 racunamo
        return this.getPrvoSlovoImenaOpetKalk();
    }
}
