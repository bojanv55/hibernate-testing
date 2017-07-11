package me.vukas.hibernate.domen.unidirekciona;

import javax.persistence.*;

@Entity
@Table(name = "sin_prima")
public class SinPrimaIdOdOca {

    //kompozitni ID koji sadrzi nesto specificno za ovu tabelu i ID koji odreduje otac ove relacije
    @EmbeddedId
    private SinPrimaId id;  //ovo je klasa koja sadrzi ID koji uparuje ID oca i jos neke parametre lokalno


    private String kom;

    @ManyToOne
    @JoinColumn(name = "orac_id")
    @MapsId("ooid") //naziv fielda u klasi OtacOdredjujeId
    private OtacOdredjujeId otac;

    public void setOtac(OtacOdredjujeId otac) {
        this.otac = otac;
    }

    public void setKom(String kom) {
        this.kom = kom;
    }

    public void setId(SinPrimaId id) {
        this.id = id;
    }

    public String getKom() {
        return kom;
    }
}
