package me.vukas.hibernate.domen.unidirekciona;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "otac_vise_saattr")
public class OtacViseSaAttr {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //ako je auto hibernate bira strategiju
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;

	@Version
	private int version;

//RADIRADI
//	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "otac")
//	private List<ViseUViseSaAttr> viseUVise = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "otac_relacije") //podesavamo kolonu u djetetu za FK
	private List<ViseUViseSaAttr> viseUVise = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<ViseUViseSaAttr> getViseUVise() {
		return viseUVise;
	}

	public void setViseUVise(List<ViseUViseSaAttr> viseUVise) {
		this.viseUVise = viseUVise;
	}
}
