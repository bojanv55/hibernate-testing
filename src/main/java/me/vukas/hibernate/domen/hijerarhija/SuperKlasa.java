package me.vukas.hibernate.domen.hijerarhija;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

//@MappedSuperclass	//samo ako su sinovi u dvije posebne tabele a super klasa nema tabelu
@Entity
@Inheritance(strategy = InheritanceType.JOINED)	//postoji jos strategija TABLE_PER_CLASS, SINGLE_TABLE
@Table(name = "super_klasa")
public abstract class SuperKlasa {

	/**
	 * JOINED = dobra za smanjeni broj cuvanja podataka al sporija jer moramo da raidmo join
	 * TABLE_PER_CLASS = koliko klasa toliko i tabela (u ovom slucaju 3 tabele jer se mapira i superklasa)
	 * SINGLE_TABLE = sve se nalazi u 1 tabeli, ali moramo koristiti diskriminator kolonu kako bi znali o kojoj se klasi radi (po def. dtype je ime kolone)
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int zajedno;

	public int getZajedno() {
		return zajedno;
	}

	public void setZajedno(int zajedno) {
		this.zajedno = zajedno;
	}
}
