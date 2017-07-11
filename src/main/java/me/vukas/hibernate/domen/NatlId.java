package me.vukas.hibernate.domen;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "natid")
public class NatlId {

	@EmbeddedId
	@NaturalId
	private JMBG jmbg;

	public void setJmbg(JMBG jmbg) {
		this.jmbg = jmbg;
	}
}
