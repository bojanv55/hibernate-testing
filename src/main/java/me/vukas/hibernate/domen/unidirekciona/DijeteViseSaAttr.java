package me.vukas.hibernate.domen.unidirekciona;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dijete_vise_saattr")
public class DijeteViseSaAttr {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //ako je auto hibernate bira strategiju
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;

}
