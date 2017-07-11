package me.vukas.hibernate.domen.unidirekciona;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "vise_vise_saattr")
public class ViseUViseSaAttr {

	@EmbeddedId
	ViseUViseSaAttrId id;

	private String dodatno;

	//RADIRADI
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "otac_relacije")   //kolona u koju se cuva id oca (FK)
	@MapsId("otacId")
	private OtacViseSaAttr otac;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dijetevise_id")   //kolona u koju se cuva id oca (FK)
	@MapsId("dijeteId")
	private DijeteViseSaAttr dijete;

	public ViseUViseSaAttrId getId() {
		return id;
	}

	//RADIRADI
//	public OtacViseSaAttr getOtac() {
//		return otac;
//	}
//
//	public void setOtac(OtacViseSaAttr otac) {
//		this.otac = otac;
//	}

	public void setId(ViseUViseSaAttrId id) {
		this.id = id;
	}

	public String getDodatno() {
		return dodatno;
	}

	public void setDodatno(String dodatno) {
		this.dodatno = dodatno;
	}

	public OtacViseSaAttr getOtac() {
		return otac;
	}

	public void setOtac(OtacViseSaAttr otac) {
		this.otac = otac;
	}

	public DijeteViseSaAttr getDijete() {
		return dijete;
	}

	public void setDijete(DijeteViseSaAttr dijete) {
		this.dijete = dijete;
	}
}
