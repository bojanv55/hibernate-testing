package me.vukas.hibernate.domen.hijerarhija;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "sub_klasa_1")
@PrimaryKeyJoinColumn(name = "sk_id")
public class SubKlasa1 extends SuperKlasa {

	private String nesto1;

	public String getNesto1() {
		return nesto1;
	}

	public void setNesto1(String nesto1) {
		this.nesto1 = nesto1;
	}
}
