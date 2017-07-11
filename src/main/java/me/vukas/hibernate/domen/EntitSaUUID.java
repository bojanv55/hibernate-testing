package me.vukas.hibernate.domen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity //ime tabele je entit_sauuid
public class EntitSaUUID {

    @Id
    @GeneratedValue //UUID u bazi je BINARY(16) jer je 32char hex = 128bita a 1 binary u mysql ima 8bita; 16*8=128
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    private String ime;

    public UUID getId() {
        return id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }
}
