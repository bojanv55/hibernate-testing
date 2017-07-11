package me.vukas.hibernate.domen.hijerarhija;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "sub_klasa_2")
@PrimaryKeyJoinColumn(name = "sk_id")
public class SubKlasa2 extends SuperKlasa {

	private String nesto2;

	public String getNesto2() {
		return nesto2;
	}

	public void setNesto2(String nesto2) {
		this.nesto2 = nesto2;
	}
}
