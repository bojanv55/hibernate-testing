package me.vukas.hibernate.domen;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class JMBG implements Serializable {

	@Column(name = "jmbg")
	private String value;

	private JMBG() {
	}

	public JMBG(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
