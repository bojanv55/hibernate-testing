package me.vukas.hibernate.domen.unidirekciona;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ViseUViseSaAttrId implements Serializable {
	private static final long serialVersionUID =
			123434223L;

	//RADIRADI
	private Long otacId;

	private Long dijeteId;

	public ViseUViseSaAttrId(){}

	public ViseUViseSaAttrId(Long otacId, Long dijeteId) {
		this.otacId = otacId;
		this.dijeteId = dijeteId;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getOtacId() {
		return otacId;
	}

	public void setOtacId(Long otacId) {
		this.otacId = otacId;
	}

	public Long getDijeteId() {
		return dijeteId;
	}

	public void setDijeteId(Long dijeteId) {
		this.dijeteId = dijeteId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		ViseUViseSaAttrId that = (ViseUViseSaAttrId)o;

//		if (otacId != null ? !otacId.equals(that.otacId) : that.otacId != null)
//			return false;
		return dijeteId != null ? dijeteId.equals(that.dijeteId) : that.dijeteId == null;
	}

	@Override
	public int hashCode() {
		int result = /*otacId != null ? otacId.hashCode() :*/ 0;
		result = 31 * result + (dijeteId != null ? dijeteId.hashCode() : 0);
		return result;
	}
}
