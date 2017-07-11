package me.vukas.hibernate.domen.unidirekciona;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SinPrimaId implements Serializable {
    private static final long serialVersionUID = 2324234L;

    private Integer ooid;

    @Column(name = "moze_dod_id")
    private Integer mozedodid;  //moze i bez ovoga - tj samo da ooid imamo u klasi

    public SinPrimaId(){}

    public SinPrimaId(Integer ooid, Integer mozedodid) {
        this.ooid = ooid;
        this.mozedodid = mozedodid;
    }

    public Integer getOoid() {
        return ooid;
    }

    public void setOoid(Integer ooid) {
        this.ooid = ooid;
    }

    public Integer getMozedodid() {
        return mozedodid;
    }

    public void setMozedodid(Integer mozedodid) {
        this.mozedodid = mozedodid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SinPrimaId that = (SinPrimaId) o;

        return ooid != null ? ooid.equals(that.ooid) : that.ooid == null;
    }

    @Override
    public int hashCode() {
        return ooid != null ? ooid.hashCode() : 0;
    }
}
