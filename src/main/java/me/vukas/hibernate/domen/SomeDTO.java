package me.vukas.hibernate.domen;

public class SomeDTO {
	private long id;
	private long idoca;

	public SomeDTO(long id, long idoca) {
		this.id = id;
		this.idoca = idoca;
	}

	public long getId() {
		return id;
	}

	public long getIdoca() {
		return idoca;
	}

	@Override
	public String toString() {
		return "SomeDTO{" +
				"id=" + id +
				", idoca=" + idoca +
				'}';
	}
}
